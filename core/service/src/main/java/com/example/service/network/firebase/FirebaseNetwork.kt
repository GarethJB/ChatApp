package com.example.service.network.firebase

import android.util.Log
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class FirebaseNetwork @Inject constructor(
    private val database: FirebaseDatabase
) {


    fun getDataSingleValueEventListener(map: Map<String, String>): Flow<DataSnapshot> = callbackFlow {

        val reference = map["reference"] as String
        val child = map["child"] as String
        val orderByChild = map["orderByChild"] as String

        database
            .getReference(reference)
            .child(child)
            .orderByChild(orderByChild)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    trySend(snapshot)
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("JB", "onCancelled: $error")
                }

            })

    }

    fun getDataChildEventListener(map: Map<String, String>): Flow<DataSnapshot> = callbackFlow {

        val reference = map["reference"] as String
        val child = map["child"] as String

        database
            .getReference(reference)
            .child(child)
            .addChildEventListener(object : ChildEventListener {
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    trySend(snapshot)
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                    trySend(snapshot)
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                    trySend(snapshot)
                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                    trySend(snapshot)
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("JB", "onCancelled: $error")
                }

            })
    }

}