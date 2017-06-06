package com.sdwfqin.mvprelam.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sdwfqin.mvprelam.R
import com.sdwfqin.mvprelam.module.ertry.Student

/**
 * 第一个参数是实体类，第二个参数是ViewHolder(可以自定义，必须继承BaseViewHolder)
 *
 * Created by sdwfqin on 2017/5/19.
 */
class MainAdapter(layoutResId: Int, data: MutableList<Student>?) : BaseQuickAdapter<Student, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder, item: Student) {
        // 添加点击事件
        helper.addOnClickListener(R.id.ll_a)
                .addOnClickListener(R.id.btn_del)
                .addOnClickListener(R.id.btn_xg)
                .setText(R.id.tv_xh, item.id.toString())
                .setText(R.id.tv_xm, item.name)
                .setText(R.id.tv_xb, item.sex)
                .setText(R.id.tv_dz, item.address)
    }
}