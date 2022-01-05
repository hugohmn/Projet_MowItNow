package moveTondeuse

/*Classe qui prend en compte la sens de la tondeuse*/

object Sens extends Enumeration {
  //Enumeration permet de rentrer plusieurs valeurs possibles (ici 4)
  type Sens = Value
  val N, E, S, O = Value
}
