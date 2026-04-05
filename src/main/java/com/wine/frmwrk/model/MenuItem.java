package com.wine.frmwrk.model;

/**
 * Représente un élément du menu de navigation.
 * <p>
 * La clé i18n est résolue par Thymeleaf via {@code #{cleI18n}}.
 * L'autorité requise est {@code null} si l'accès nécessite
 * simplement d'être authentifié, sans rôle particulier.
 * </p>
 *
 * @param cleI18n         Clé de message pour le libellé (ex: {@code header.dashboard})
 * @param url             URL de destination (ex: {@code /dashboard})
 * @param autoriteRequise Autorité Spring Security requise, ou {@code null}
 */
public record MenuItem(String cleI18n, String url, String autoriteRequise) {}
