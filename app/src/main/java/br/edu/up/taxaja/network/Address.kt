package br.edu.up.taxaja.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

data class Address(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String
)

interface ViaCepService {
    @GET("{cep}/json/")
    suspend fun getAddress(@Path("cep") cep: String): Address

    companion object {
        private const val BASE_URL = "https://viacep.com.br/ws/"

        fun create(): ViaCepService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ViaCepService::class.java)
        }
    }
}