package moveTondeuse

/*Classe qui prend en compte la sens de la tondeuse*/

object Direction extends Enumeration {
  //Enumeration permet de rentrer plusieurs valeurs possibles (ici 4)
  type Direction = Value
  val N, E, S, O = Value
}
