package com.example.associationwords.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.associationwords.R
import com.example.associationwords.databinding.ActivityStartBinding
import com.example.associationwords.databinding.AppBarMainBinding
import com.example.associationwords.databinding.NavViewHeaderMainBinding
import com.google.firebase.auth.FirebaseAuth

class StartActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "StartActivity"
    }

    //DataBinding
    private lateinit var navViewHeaderMain: NavViewHeaderMainBinding
    private lateinit var appBarMainBinding: AppBarMainBinding
    private lateinit var binding: ActivityStartBinding

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start)
        setupToolbar()
        setupNavigationViewHeader()
        setupNavigationView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setupToolbar() {
        DataBindingUtil.getBinding<AppBarMainBinding>(binding.drawerLayout.getChildAt(0)).let {
            appBarMainBinding = it!!
            toolbar = it.toolbarStartActivity
            setSupportActionBar(toolbar)
        }
    }

    private fun setupNavigationViewHeader() {
        val viewHeader = binding.navView.getHeaderView(0)
        navViewHeaderMain = NavViewHeaderMainBinding.bind(viewHeader)
    }

    private fun setupNavigationView() {
        val navController = findNavController(R.id.nav_host_fragment)
        val setNavFragments =
            setOf(
                R.id.nav_home,
                R.id.nav_gallery,
                R.id.nav_slideshow,
                R.id.nav_settings
            )
        appBarConfiguration = AppBarConfiguration(setNavFragments, binding.drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    private fun checkCurrentUser() {
        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
            sigIn()
        }
    }
}
