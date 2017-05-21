package com.sdwfqin.kotlinandroidsamples.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.EditText
import com.sdwfqin.kotlinandroidsamples.R
import com.sdwfqin.kotlinandroidsamples.adapter.MainAdapter
import com.sdwfqin.kotlinandroidsamples.module.ertry.Student
import com.sdwfqin.kotlinandroidsamples.presenter.MainPresenter
import com.sdwfqin.kotlinandroidsamples.presenter.MainPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sheet_dialog.view.*
import module.interactor.MainInteractorImpl
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity(), MainView, AnkoLogger {

    private val TAG = "MainActivity"
    /**
     * lateinit: 惰性初始化
     */
    private lateinit var mainPresenter: MainPresenter
    private lateinit var mainAdapter: MainAdapter
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mBottomSheetDialog: BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 去除自带标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        toolbar_title.visibility = View.VISIBLE
        toolbar_title.text = "KotlinSample"

        inflateMenu()
        initSearchView()
        initView()

        mainPresenter = MainPresenterImpl(this, MainInteractorImpl())
    }

    private fun initView() {

        mRecyclerView = recycler
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        mainAdapter = MainAdapter(R.layout.item_home, null)
        mainAdapter.openLoadAnimation()

        mRecyclerView.adapter = mainAdapter

        srl.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light)

        srl.setOnRefreshListener {
            mainPresenter.onResume()
        }
        fab.setOnClickListener {
            mainPresenter.createData()
        }

        mainAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.btn_xg -> {
                    error { "onItemClick: " + "修改" }
                    mainPresenter.OnClickUpData(adapter.getItem(position) as Student, position)
                }
                R.id.btn_del -> {
                    error { "onItemClick: " + "删除" }
                    mainPresenter.OnClickDelData(adapter.getItem(position) as Student, position)
                }
                R.id.ll_a -> error { "onItemClick: " + "点击条目" }
            }
        }
    }

    private fun inflateMenu() {
        toolbar.inflateMenu(R.menu.menu_frist)
        toolbar.setOnMenuItemClickListener {
            item ->
            when (item.itemId) {
                R.id.menu_about -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/sdwfqin"))
                    startActivity(intent)
                }
            }
            return@setOnMenuItemClickListener true
        }
    }

    private fun initSearchView() {
        val search: MenuItem = toolbar.menu.findItem(R.id.menu_search)
        val searchView = search.actionView as SearchView

        searchView.queryHint = "这里没有做处理呦！"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                error { query }
                return false
            }

            override fun onQueryTextChange(s: String?): Boolean {
                error { s }
                return false
            }

        })
    }

    /**
     * 加载数据
     */
    override fun onResume() {
        super.onResume()
        mainPresenter.onResume()
    }

    override fun showProgress() {
        srl.isRefreshing = true
    }

    override fun hideProgress() {
        srl.isRefreshing = false
    }

    override fun showBottomSheetDialog() {
        var v = View.inflate(this, R.layout.sheet_dialog, null)
        mBottomSheetDialog = BottomSheetDialog(this)
        mBottomSheetDialog.setContentView(v)

        v.btn_enter.setOnClickListener {
            var xh: Long = 0
            try {
                xh = (v.et_xh.text.toString().trim()).toLong()
            } catch (e: NumberFormatException) {
                toast("学号请输入数字")
                return@setOnClickListener
            }

            var name: String = v.et_name.text.toString().trim()
            var age: String = v.et_sex.text.toString().trim()
            var address: String = v.et_address.text.toString().trim()

            if (xh == 0L || name.isEmpty() || age.isEmpty() || address.isEmpty()) {
                toast("内容不能为空")
                mBottomSheetDialog.dismiss()
                return@setOnClickListener
            }
            var student = Student(xh, name, age, address)

            mainPresenter.OnCreateData(student)
        }
        mBottomSheetDialog.show()
    }

    override fun upData(student: Student, position: Int) {
        var builder: AlertDialog.Builder = AlertDialog.Builder(this)
                .setTitle("修改")

        var view = View.inflate(this, R.layout.dialog_xg, null)
        var et_name = view.findViewById(R.id.et_name) as EditText
        var et_sex = view.findViewById(R.id.et_sex) as EditText
        var et_address = view.findViewById(R.id.et_address) as EditText

        et_name.setText(student.name)
        et_sex.setText(student.sex)
        et_address.setText(student.address)

        builder.setView(view)

        builder.setPositiveButton(
                "完成",
                {
                    // 这里如果忽略会报错
                    dialog, which ->
                    var name = et_name.text.toString().trim()
                    var sex = et_sex.text.toString().trim()
                    var address = et_address.text.toString().trim()

                    if (name.isEmpty() || sex.isEmpty() || address.isEmpty()) {
                        toast(" 内容不能为空 ")
                        return@setPositiveButton
                    }

                    student.name = name
                    student.sex = sex
                    student.address = address

                    mainPresenter.OnUpData(student, position)
                })
        builder.setNegativeButton("取消", { dialog, which -> })

        var alertDialog = builder.create()
        alertDialog.show()
    }

    override fun upAdapter(student: Student, position: Int) {
        mainAdapter.remove(position)
        mainAdapter.addData(position, student)
    }

    override fun upAdapter(position: Int) {
        // 删除数据
        mainAdapter.remove(position)
    }

    override fun addAdapter(student: Student) {
        mainAdapter.addData(0, student)
        mRecyclerView.layoutManager.scrollToPosition(0)
        mBottomSheetDialog.dismiss()
    }

    override fun showMessage(message: String) {
        toast(message)
    }

    override fun setItems(items: List<Student>) {
        mainAdapter.setNewData(items)
    }

    override fun onDestroy() {
        mainPresenter.onDestroy()
        super.onDestroy()
    }
}
