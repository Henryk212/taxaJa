package data.dao

import android.app.Application
import androidx.room.Room

class taxaJaApplication : Application() {
    lateinit var usuarioDao: UsuarioDao
    lateinit var enderecoDao: EnderecoDao
    lateinit var grupoDao: GrupoDao
    lateinit var userGroupDao: UserGroupDao
    lateinit var eventoDao: EventoDao
    lateinit var userEventDao: UserEventDao

    private set

    override fun onCreate() {
        super.onCreate()
        val database = Room.databaseBuilder(this, taxaJaApp::class.java, "taxa_ja_database")
            .fallbackToDestructiveMigration()
            .build()
        usuarioDao = database.usuarioDao()
        enderecoDao = database.enderecoDao()
        grupoDao = database.grupoDao()
        userGroupDao = database.userGroupDao()
        eventoDao = database.eventoDao()
        userEventDao = database.userEventDao()
    }

    companion object {
        lateinit var instance: taxaJaApplication
            private set
    }
}