package moveTondeuse

/*Classe qui contient la position de la tondeuse et son sens de déplacement*/

class Tondeuse(val _position: Position, val _sup_x : Int , _sup_y : Int){

  //position initiale de la tondeuse
  private val position : Position = _position

  //valeur des coordonnées
  private val sup_x: Int =  _sup_x
  private val sup_y: Int =  _sup_y

  //fonction qui permet à la tondeuse de se déplacer
  def move(command: Char): Unit = {
    command match {
      // si A, alors la tondeuse doit avancer, et il y a 4 sens possibles (Nord, Est, Sud, Ouest)
      case 'A' =>
        position.direction match {
          case Sens.NORD =>
            if (position.y < sup_y) position.y = position.y + 1
          case Sens.EST =>
            if (position.x < sup_x) position.x = position.x + 1
          case Sens.SUD =>
            if (position.y > 0) position.y = position.y - 1
          case Sens.OUEST =>
            if (position.x > 0) position.x = position.x - 1
        }
      // cas où la tondeuse doit tourner à Droite (lettre D)
      case 'D' =>
        position.direction match {
          case Sens.NORD => position.direction = Sens.EST
          case Sens.EST => position.direction = Sens.SUD
          case Sens.SUD => position.direction = Sens.OUEST
          case Sens.OUEST => position.direction = Sens.NORD
        }
      // cas où la tondeuse doit tourner à Gauche (lettre G)
      case 'G' =>
        position.direction match {
          case Sens.NORD => position.direction = Sens.OUEST
          case Sens.OUEST => position.direction = Sens.SUD
          case Sens.SUD => position.direction = Sens.EST
          case Sens.EST => position.direction = Sens.NORD
        }
    }
  }
  override def toString = s"$position"
}