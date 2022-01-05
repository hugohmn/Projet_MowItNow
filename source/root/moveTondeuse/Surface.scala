package moveTondeuse

import scala.io.BufferedSource

object Surface {
  // initialisation de deux variables
  private var sup_x: Int = _
  private var sup_y: Int = _

  //fonction qui lit et traite les valeurs du fichier Input
  def run(fileName : String): Unit = {

    // lecture du fichier
    val fichierEntree: BufferedSource = io.Source.fromFile(getClass.getResource(s"/$fileName").getFile)

    // récupération des lignes
    val lignes = fichierEntree.getLines()

    // on récupére la première ligne du fichier
    var ligne = lignes.next()

    // on sépare les coordonnées
    val coordSup = ligne.split(" ")

    sup_x = coordSup(0).toInt
    sup_y = coordSup(1).toInt

    var i = 1

    //on boucle jusqu'à qu'il n'y ait plus de lignes à traiter afin de toutes les traiter
    while (lignes.hasNext){

      ligne = lignes.next()

      // On récupére la position et le sens initial de la tondeuse qui correspond à la deuxieme ligne et on l'assigne
      val positionInitial = ligne.split(" ")

      val x = positionInitial(0).toInt
      val y = positionInitial(1).toInt

      val sensText = positionInitial(2)

      // On initialise la variable sens
      var sens = Sens.N

      sensText match {
        case "N" => sens = Sens.N
        case "E" => sens = Sens.E
        case "S" => sens = Sens.S
        case "W" => sens = Sens.O
      }

      val tondeuse = new Tondeuse(new Position(x, y, sens), sup_x, sup_y)

      // on récupère les instructions avec la ligne (liste) suivante
      ligne = lignes.next()

      val instruction = ligne.toList
      // On applique la fonction move sur chaque instruction
      instruction.foreach( tondeuse.move )

      // position finale de la tondeuse
      println(s"Position de la tondeuse $i : $tondeuse")

      i = i + 1
    }
    // fermeture du fichier
    fichierEntree.close()

  }
}

