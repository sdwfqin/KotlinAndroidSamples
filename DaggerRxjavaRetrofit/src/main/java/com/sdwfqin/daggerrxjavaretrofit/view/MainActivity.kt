package com.sdwfqin.daggerrxjavaretrofit.view

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.sdwfqin.daggerrxjavaretrofit.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_toolbar.*
import org.jetbrains.anko.toast

/**
 * Kotlin+Dagger2+Rxjava2+Retrofit
 *
 * @author sdwfqin
 * @version 2.0.0
 * @since 2017-06-06
 * <p/>
 * 博客: www.sdwfqin.com  邮箱: zhangqin@sdwfqin.com
 * 项目地址：https://github.com/sdwfqin/KotlinAndroidSamples
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar_title.visibility = View.VISIBLE
        toolbar_title.text = "微小文"

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        // 设置MenuItem默认选中项
        nav_view.menu.getItem(0).isChecked = true
        switchFragment(HomeFragment() as Fragment)
    }

    /**
     * 跳转Fragment
     */
    private fun switchFragment(newFragment: Fragment) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_fragment, newFragment).commit()
    }

    /**
     * 菜单键
     */
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            drawer_layout.openDrawer(GravityCompat.START)
        }
        return false
    }

    /**
     * 返回
     */
    var exitTime: Long = 0

    override fun onBackPressed() {
        //如果侧栏开启首先关闭侧边栏
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            if (System.currentTimeMillis() - exitTime > 2000) {
                toast(R.string.main_exit)
                exitTime = System.currentTimeMillis()
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                //主页
            }
        }

        // 关闭侧边栏
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
