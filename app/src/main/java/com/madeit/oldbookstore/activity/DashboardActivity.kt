package com.madeit.oldbookstore.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    /*private lateinit var mAppBarConfiguration: AppBarConfiguration*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // setSupportActionBar(binding.appBarDashboard.toolbar)

        val drawer: DrawerLayout = binding.drawerLayout
        val navigationView: NavigationView = binding.navView

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*mAppBarConfiguration = AppBarConfiguration.Builder(
                R.id.nav_dashboard)
                .setOpenableLayout(drawer)
                .build()*/

        /*val navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dashboard)
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration)
        NavigationUI.setupWithNavController(navigationView, navController)*/
    }

    /*override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_dashboard)
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}