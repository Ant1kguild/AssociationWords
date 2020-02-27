package com.example.needmoreassociations.data


import com.example.associationwords.model.User
import com.example.associationwords.model.UserValue
import com.example.associationwords.model.UserValue.*
import com.example.associationwords.utils.Firestore.awaitTask
import com.example.associationwords.utils.Result
import com.google.firebase.firestore.FirebaseFirestore


interface UserRepository {

    suspend fun getUserFromFirestore(userId: String): Result<User>

    suspend fun createUserInFirestore(user: User): Result<Void?>

    suspend fun changeUserInFirestore(user: User, userValue: UserValue): Result<Void?>

}

class UserRepositoryImpl : UserRepository {

    companion object {
        private const val USER = "users"
    }

    private val userCollectionRef = FirebaseFirestore.getInstance().collection(USER)

    override suspend fun getUserFromFirestore(userId: String): Result<User> {
        return when (val document = userCollectionRef.document(userId).get().awaitTask()) {
            is Result.Success -> {
                val test = document.data.toObject(User::class.java)!!
                Result.Success(test)
            }
            is Result.Error -> Result.Error(document.exception)
            is Result.Canceled -> Result.Canceled(document.exception)
        }
    }

    override suspend fun createUserInFirestore(user: User) =
        userCollectionRef.document(user.uuid).set(user).awaitTask()

    override suspend fun changeUserInFirestore(
        user: User,
        userValue: UserValue
    ): Result<Void?> {
        return when (userValue) {
            UUID -> TODO()
            NAME -> userCollectionRef.document(user.uuid).update(NAME.value, user.name).awaitTask()
            PHOTO_URL -> userCollectionRef.document(user.uuid).update(PHOTO_URL.value, user.photoUrl).awaitTask()
            MAIL -> userCollectionRef.document(user.uuid).update(MAIL.value, user.mail).awaitTask()
        }
    }
}
