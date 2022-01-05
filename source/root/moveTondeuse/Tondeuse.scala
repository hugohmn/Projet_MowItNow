package moveTondeuse

/*Classe qui contient la position de la tondeuse et son sens de déplacement*/

class Tondeuse(val _position: Position, val _sup_x : Int , _sup_y : Int){

  //position initiale de la tondeuse
  private val position : Position = _position

  //valeur des coordonnées
  private val sup_x: Int =  _sup_x
  private val sup_y: Int =  _sup_y

  //fonction qui permet à la tondeuse de se déplacer
  def move(movement: Char): Unit = {
    movement match {
      // si A, alors la tondeuse doit avancer, et il y a 4 sens possibles (Nord, Est, Sud, Ouest)
      case 'A' =>
        position.direction match {
          case Sens.N =>
            if (position.y < sup_y) position.y = position.y + 1
          case Sens.O =>
            if (position.x > 0) position.x = position.x - 1
          case Sens.S =>
            if (position.y > 0) position.y = position.y - 1
          case Sens.E =>
            if (position.x < sup_x) position.x = position.x + 1
        }
      // cas où la tondeuse doit tourner à Droite (lettre D)
      case 'D' =>
        position.direction match {
          case Sens.N => position.direction = Sens.E //si la tondeuse était direction Nord, 90° à droite correspond à l'Eest
          case Sens.O => position.direction = Sens.N
          case Sens.S=> position.direction = Sens.O //si la tondeuse était direction Sud, 90° à droite, correspond à l'Ouest
          case Sens.E => position.direction = Sens.S
        }
      // cas où la tondeuse doit tourner à Gauche (lettre G)
      case 'G' =>
        position.direction match {
          case Sens.N => position.direction = Sens.O //si la tondeuse était direction Nord, 90° à gauche correspond à l'Ouest
          case Sens.O => position.direction = Sens.S
          case Sens.S => position.direction = Sens.E
          case Sens.E => position.direction = Sens.N
        }
    }
  }
  override def toString = s"$position"
}