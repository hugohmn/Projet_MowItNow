package moveTondeuse

/*Classe qui compile la position de la tondeuse*/
class Position (val _y : Int, val _x:Int, val _sens : Sens.Value) {
  var x: Int = _x
  var y: Int = _y
  var sens: Sens.Value = _sens
  override def toString = s"$x $y ${sens.toString.charAt(0)}"
}



