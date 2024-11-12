package br.edu.up.taxaja.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import br.edu.up.taxaja.Model.Usuario
import data.dao.UsuariosRepository

class UserEntryViewModel (private val usersRepository: UsuariosRepository) : ViewModel(){
    var userUiState by mutableStateOf(UserUiState())
        private set

    fun updateUiState(userDetails : UserDetails) {
        userUiState =
            UserUiState(userDetails = userDetails, isEntryValid = validateInput(userDetails))
    }

    private fun validateInput(uiState : UserDetails = userUiState.userDetails): Boolean {
        return with(uiState) {
            nome.isNotBlank() && email.isNotBlank() && telefone.isNotBlank() && nomeUsuario.isNotBlank() && senha.isNotBlank() && sexo.isNotBlank()
        }
    }

    suspend fun saveUser() {
        if (validateInput()) {
            usersRepository.insertUsuario(userUiState.userDetails.toUser())
        }
    }

    data class UserUiState(
        val userDetails: UserDetails = UserDetails(),
        val isEntryValid: Boolean = false
    )

    data class UserDetails(
        val id: Int = 0,
        val nome: String = "",
        val email: String = "",
        val telefone: String = "",
        val nomeUsuario: String = "",
        val senha: String = "",
        val sexo: String = ""
    )

    fun UserDetails.toUser(): Usuario = Usuario(
        id = id,
        nome = nome,
        email = email,
        telefone = telefone,
        nomeUsuario = nomeUsuario,
        senha = senha,
        sexo = sexo
    )

    fun Usuario.toUserUiState(isEntryValid : Boolean = false): UserUiState = UserUiState(
        userDetails = this.toUserDetails(),
        isEntryValid = isEntryValid
    )

    fun Usuario.toUserDetails(): UserDetails = UserDetails(
        id = id,
        nome = nome,
        email = email,
        telefone = telefone,
        nomeUsuario = nomeUsuario,
        senha = senha,
        sexo = sexo
    )
}