package com.golaso.dao;

import com.golaso.modal.Player;

/**
 * Created by dheinisch on 12/8/17.
 */
public interface PlayerDao {
    Player create(Player player);
    Player read(String id);
}
