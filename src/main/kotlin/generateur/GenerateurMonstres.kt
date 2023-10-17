package generateur
import arme
import model.item.Item
import model.item.Qualite
import model.personnage.Personnage
import java.nio.file.Paths
import java.nio.file.Files


/**
 * La classe GenerateurQualites permet de générer des objets de type Qualite à partir d'un fichier CSV.
 *
 * @param cheminFichier Le chemin vers le fichier CSV contenant les données des qualités.
 */
class GenerateurMonstres(val cheminFichier: String) {
    /**
     * Génère et retourne un mapping des qualités à partir des données contenues dans le fichier CSV.
     *
     * @return Un mapping des qualités où la clé est le nom de la qualité en minuscules et la valeur est un objet Qualite.
     */
    fun generer(): MutableMap<String, Personnage>{
        val mapObjets = mutableMapOf<String, Personnage>()

        // Lecture du fichier CSV, le contenu du fichier est stocké dans une liste mutable :
        val cheminCSV = Paths.get(this.cheminFichier)
        val listeObjCSV = Files.readAllLines(cheminCSV)



        // Instance des objets :
        for (i in 1..listeObjCSV.lastIndex) {
            val ligneObjet = listeObjCSV[i].split(";")
            val unInventaire :MutableList<Item> = mutableListOf()

            val listeNomArme =ligneObjet[9].split(".")
            for (unNomArme in listeNomArme){
                unInventaire.add(arme[unNomArme])
            }


            val cle = ligneObjet[0].lowercase()
            val objet = Personnage(nom = ligneObjet[0], pointDeVie = ligneObjet[1].toInt(), pointDeVieMax =ligneObjet[2].toInt(), attaque = ligneObjet[3].toInt(), defense = ligneObjet[3].toInt(), endurance = ligneObjet[4].toInt(), )
        }
        return mapObjets
}

