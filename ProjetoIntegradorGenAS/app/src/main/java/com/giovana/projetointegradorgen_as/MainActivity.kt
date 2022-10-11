package com.giovana.projetointegradorgen_as

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController

import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.giovana.projetointegradorgen_as.adapter.PostagemAdapter
import com.giovana.projetointegradorgen_as.databinding.CardLayoutBinding.inflate
import com.giovana.projetointegradorgen_as.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    //    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Bem vindo!", Toast.LENGTH_LONG).show()
//        setSupportActionBar(findViewById(R.id.toolbar))
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                as NavHostFragment
        navController = navHostFragment.findNavController()
//        drawerLayout = findViewById(R.id.drawer_layout)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//
//        setupActionBarWithNavController(navController, appBarConfiguration)


    }
//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp(appBarConfiguration) || return super.onSupportNavigateUp()
//    }


}