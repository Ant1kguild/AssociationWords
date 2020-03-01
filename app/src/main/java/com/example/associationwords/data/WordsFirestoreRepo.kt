package com.example.associationwords.data

import com.google.firebase.firestore.FirebaseFirestore


interface WordsFirestoreRepo {

    suspend fun getWords(): Map<String, List<String>>

    suspend fun getAssociation(word: String) : List<String>

    suspend fun addWord(word: String)

    suspend fun addAssociationToWord(word: String, association: String)

    suspend fun deleteWord(word:String)

    suspend fun  deleteAssociations(word: String, association: String)
}

class WordsFirestoreRepoImpl : WordsFirestoreRepo {

    companion object {
        private const val WORDS = "words"
    }

    private val userCollectionRef = FirebaseFirestore.getInstance().collection(WORDS)

    override suspend fun getWords(): Map<String, List<String>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getAssociation(word: String): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun addWord(word: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun addAssociationToWord(word: String, association: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteWord(word: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteAssociations(word: String, association: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}