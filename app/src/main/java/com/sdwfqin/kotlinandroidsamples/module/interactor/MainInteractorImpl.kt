package module.interactor

import com.sdwfqin.kotlinandroidsamples.module.ertry.Student
import com.sdwfqin.kotlinandroidsamples.module.interactor.MainInteractor
import io.realm.Realm
import io.realm.RealmResults
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error


/**
 * Created by sdwfqin on 2017/5/19.
 */
class MainInteractorImpl(
        val realm: Realm = Realm.getDefaultInstance()
) : MainInteractor, AnkoLogger {

    override fun initData(listener: MainInteractor.OnFinishedListener) {
        error { "initData" }
        var list: ArrayList<Student>
        try {
            var rr: RealmResults<Student> = realm.where(Student::class.java).findAll()
            list = realm.copyFromRealm(rr) as ArrayList<Student>
            listener.onFinishedSuccess(list)
            error { list.toString() }
        } catch (e: Exception) {
            error { e }
            listener.onFinishedError("数据读取失败")
        }
    }

    override fun upData(student: Student, onMesListener: MainInteractor.OnMesListener) {
        error { "修改" }
        try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(student)
            realm.commitTransaction()
            onMesListener.onMesSuccess("修改成功")
        } catch (e: Exception) {
            onMesListener.onMesError("修改失败")
            error { e }
        }

    }

    override fun delData(student: Student, onMesListener: MainInteractor.OnMesListener) {
        error { student.toString() }
        try {
            val user = realm.where(Student::class.java).equalTo("id", student.id).findFirst()
            realm.beginTransaction()
            user.deleteFromRealm()
            realm.commitTransaction()
            onMesListener.onMesSuccess("删除成功")
        } catch (e: Exception) {
            onMesListener.onMesError("删除失败")
            error { e }
        }

    }

    override fun createData(student: Student, onMesListener: MainInteractor.OnMesListener) {
        try {
            error { student }
            realm.beginTransaction()
            realm.copyToRealm(student)
            realm.commitTransaction()
            onMesListener.onMesSuccess("添加成功")
        } catch (e: Exception) {
            onMesListener.onMesError("添加失败")
            error { e }
        }
    }

    override fun onDestroy() {
        realm.close()
    }
}
