package com.wine.frmwrk.service;

import com.wine.frmwrk.model.MenuItem;
import java.util.List;

/**
 * Service de gestion du menu de navigation.
 * <p>
 * Retourne la liste des éléments de menu accessibles
 * à l'utilisateur courant en fonction de ses autorités.
 * </p>
 */
public interface MenuService {

    /**
     * Retourne les éléments de menu auxquels l'utilisateur connecté a accès.
     *
     * @return liste non nulle des éléments de menu visibles
     */
    List<MenuItem> getMenu();
}
