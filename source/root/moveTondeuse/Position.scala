package moveTondeuse

/*Classe qui compile la position de la tondeuse*/
class Position (val _y: Int, val _x:Int, val _sens: Direction.Value) {
  var x: Int = _x
  var y: Int = _y
  var direction: Direction.Value = _sens
  override def toString = s"$x $y ${direction.toString.charAt(0)}"
}



