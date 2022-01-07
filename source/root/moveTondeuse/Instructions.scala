package moveTondeuse

import scala.io.BufferedSource

object Instructions {
  // initialisation de deux variables
  private var coord_x: Int = _
  private var coord_y: Int = _

  //fonction qui lit et traite les valeurs du fichier Input
  def run(fileName : String): Unit = {

    // lecture du fichier
    val fichierEntree: BufferedSource = io.Source.fromFile(getClass.getResource(s"/$fileName").getFile)

    // récupération des lignes
    val lignes = fichierEntree.getLines()

    // on récupére la première ligne du fichier
    var ligne = lignes.next()

    // on sépare les coordonnées
    val coord = ligne.split(" ")

    coord_x = coord(0).toInt
    coord_y = coord(1).toInt

    var i = 1

    //on boucle jusqu'à qu'il n'y ait plus de lignes à traiter afin de toutes les traiter
    while (lignes.hasNext){

      ligne = lignes.next()

      // On récupére la position et le sens initial de la tondeuse qui correspond à la deuxieme ligne et on l'assigne
      val positionInitiale = ligne.split(" ")

      val x = positionInitiale(0).toInt
      val y = positionInitiale(1).toInt

      val sensText = positionInitiale(2)

      // On initialise la variable sens
      var sens = Direction.N

      sensText match {
        case "N" => sens = Direction.N
        case "E" => sens = Direction.E
        case "S" => sens = Direction.S
        case "W" => sens = Direction.O
      }

      val tondeuse = new Deplacement(new Position(x, y, sens), coord_x, coord_y)

      // on récupère les instructions avec la ligne (liste) suivante
      ligne = lignes.next()

      val instruction = ligne.toList
      // On applique la fonction move sur chaque instruction
      instruction.foreach(tondeuse.move)

      // position finale de la tondeuse
      println(s"Position finale de la tondeuse $i : $tondeuse")

      i += 1
    }
    // fermeture du fichier
    fichierEntree.close()

  }
}

