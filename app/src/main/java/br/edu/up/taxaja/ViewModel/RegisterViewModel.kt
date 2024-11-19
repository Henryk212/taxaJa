package br.edu.up.taxaja.ViewModel

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.up.taxaja.Model.Usuario
import br.edu.up.taxaja.network.ViaCepService
import data.dao.taxaJaApp
import kotlinx.coroutines.launch

class RegisterViewModel(taxaJaApp: taxaJaApp) : ViewModel() {

    private val userDao = taxaJaApp.usuarioDao()
    private val enderecoDao = taxaJaApp.enderecoDao()

    private val _fullName = mutableStateOf("")
    val fullName: State<String> = _fullName

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _phone = mutableStateOf("")
    val phone: State<String> = _phone

    private val _cep = mutableStateOf("")
    val cep: State<String> = _cep

    private val _street = mutableStateOf("")
    val street: State<String> = _street

    private val _number = mutableStateOf("")
    val number: State<String> = _number

    private val _neighborhood = mutableStateOf("")
    val neighborhood: State<String> = _neighborhood

    private val _complement = mutableStateOf("")
    val complement: State<String> = _complement

    private val _city = mutableStateOf("")
    val city: State<String> = _city

    private val _state = mutableStateOf("")
    val state: State<String> = _state

    private val _username = mutableStateOf("")
    val username: State<String> = _username

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _selectedInterestGroups = mutableStateOf(listOf<String>())
    val selectedInterestGroups: State<List<String>> = _selectedInterestGroups

    private val viaCepService = ViaCepService.create()

    fun onFullNameChange(newFullName: String) { _fullName.value = newFullName }
    fun onEmailChange(newEmail: String) { _email.value = newEmail }
    fun onPhoneChange(newPhone: String) { _phone.value = newPhone }
    fun onCepChange(newCep: String) {
        _cep.value = newCep
        if (newCep.length == 8) {
            fetchAddress(newCep)
        }
    }
    fun onStreetChange(newStreet: String) { _street.value = newStreet }
    fun onNumberChange(newNumber: String) { _number.value = newNumber }
    fun onComplementChange(newComplement: String) { _complement.value = newComplement }
    fun onNeighborhoodChange(newNeighborhood: String) { _neighborhood.value = newNeighborhood }
    fun onCityChange(newCity: String) { _city.value = newCity }
    fun onStateChange(newState: String) { _state.value = newState }
    fun onUsernameChange(newUsername: String) { _username.value = newUsername }
    fun onPasswordChange(newPassword: String) { _password.value = newPassword }
    fun onInterestGroupChange(group: String) {
        val currentGroups = _selectedInterestGroups.value.toMutableList()
        if (currentGroups.contains(group)) {
            currentGroups.remove(group)
        } else {
            currentGroups.add(group)
        }
        _selectedInterestGroups.value = currentGroups
    }

    private fun fetchAddress(cep: String) {
        viewModelScope.launch {
            try {
                val address = viaCepService.getAddress(cep)
                _street.value = address.logradouro
                _neighborhood.value = address.bairro
                _city.value = address.localidade
                _state.value = address.uf
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    suspend fun saveUser() {
        val user = Usuario(
            id = 0,
            nome = _fullName.value,
            email = _email.value,
            telefone = _phone.value,
            nomeUsuario = _username.value,
            senha = _password.value,
            sexo = "M" // ou outro valor conforme necessário

        )

        userDao.insert(user)
        saveAddress()
    }

    suspend fun saveAddress() {
        val address = br.edu.up.taxaja.Model.Endereco(
            id = 0,
            cep = _cep.value,
            rua = _street.value,
            numero = _number.value,
            complemento = _complement.value,
            bairro = _neighborhood.value,
            cidade = _city.value,
            uf = _state.value,
            userId = 0 // ou outro valor conforme necessário
        )
        enderecoDao.insert(address)
    }
}