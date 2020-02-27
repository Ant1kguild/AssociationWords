package com.example.needmoreassociations.data



interface WordsDaraSource {

    suspend fun getWords(): Map<String, List<String>>

    suspend fun getAssociation(word: String) : List<String>

    suspend fun addWord(word: String)

    suspend fun addAssociationToWord(word: String, association: String)

    suspend fun deleteWord(word:String)

    suspend fun  deleteAssociations(word: String, association: String)
}