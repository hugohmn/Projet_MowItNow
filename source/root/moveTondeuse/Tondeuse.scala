package moveTondeuse

/*Classe qui contient la position de la tondeuse et son sens de déplacement*/

class Tondeuse(val position_init: Position, val coordonnee_x : Int , coordonnee_y : Int){

  //position initiale de la tondeuse
  val position : Position = position_init

  //valeur des coordonnées
  val coord_x: Int = coordonnee_x
  val coord_y: Int = coordonnee_y

  //fonction qui permet à la tondeuse de se déplacer
  def move(movement: Char): Unit = {
    movement match {
      // si A, alors la tondeuse doit avancer, et il y a 4 sens possibles (Nord, Est, Sud, Ouest)
      case 'A' =>
        position.direction match {
          case Direction.N =>
            if (position.y < coord_y) position.y = position.y + 1
          case Direction.O =>
            if (position.x > 0) position.x = position.x - 1
          case Direction.S =>
            if (position.y > 0) position.y = position.y - 1
          case Direction.E =>
            if (position.x < coord_x) position.x = position.x + 1
        }
      // cas où la tondeuse doit tourner à Droite (lettre D)
      case 'D' =>
        position.direction match {
          case Direction.N => position.direction = Direction.E //si la tondeuse était direction Nord, 90° à droite correspond à l'Eest
          case Direction.O => position.direction = Direction.N
          case Direction.S => position.direction = Direction.O //si la tondeuse était direction Sud, 90° à droite, correspond à l'Ouest
          case Direction.E => position.direction = Direction.S
        }
      // cas où la tondeuse doit tourner à Gauche (lettre G)
      case 'G' =>
        position.direction match {
          case Direction.N => position.direction = Direction.O //si la tondeuse était direction Nord, 90° à gauche correspond à l'Ouest
          case Direction.O => position.direction = Direction.S
          case Direction.S => position.direction = Direction.E
          case Direction.E => position.direction = Direction.N
        }
    }
  }
  override def toString = s"$position"
}