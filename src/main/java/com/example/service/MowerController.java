/**
 * Contrôleur métier qui applique une instruction à une tondeuse.
 * 
 * Contient la logique de mouvement (avancer, rotation) en fonction
 * de l'orientation actuelle, de la pelouse et des limites.
 * 
 * Design pattern utilisé : Strategy possible pour modulariser les actions
 * (Gauche, Droite, Avancer).
 */
package com.example.service;

import com.example.domain.Lawn;
import com.example.domain.Mower;

class MowerController {
 
    private final Mower mower;
    private final Lawn lawn;

    public MowerController(Mower mower, Lawn lawn) {
        this.mower = mower;
        this.lawn = lawn;
    }

}