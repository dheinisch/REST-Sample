package com.golaso.dao;

import com.golaso.modal.Player;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dheinisch on 12/8/17.
 */
public class PlayerDaoImpl implements PlayerDao{
    private Map<String, Player> players = new HashMap<>();
    @Override
    public Player create(final Player player) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance( );
        DatabaseReference ref = database.getReference("users");

        Map<String, Player> values = new HashMap<>();
        values.put(player.getId(), player);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                players.put(player.getId(), dataSnapshot.getValue(Player.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ref.setValueAsync(values);

        return player;
    }

    @Override
    public Player read(String id) {
        return players.get(id);
    }
}
