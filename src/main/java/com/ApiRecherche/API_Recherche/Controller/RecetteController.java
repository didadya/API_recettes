package com.ApiRecherche.API_Recherche.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ApiRecherche.API_Recherche.Model.Recette;

@RestController
public class RecetteController {

	List<Recette> recettes = new ArrayList<Recette>();
	
	// Récuperer la liste de toutes le recettes
	@GetMapping("/recettes")
    private List<Recette> getAllRecettes() throws ClassNotFoundException {
		
        String sql = "SELECT * FROM `recette`";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_recettes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "SAMdid781227");
            java.sql.Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next())
            { 
              recettes.add(new Recette(rs.getInt("id_recette"), rs.getString("libelle"), rs.getString("niveau"), rs.getInt("duree_cuissant"), rs.getString("ingredients"), rs.getString("preparation")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return recettes;
    }
	
	// Recherche par libelle
	@GetMapping("recettes/recherche/{motCle}")
	private List<Recette> RechercherRecettes() throws ClassNotFoundException {
		
        String sqlRecherche = "SELECT * FROM recette where `libelle` like `{motCle}` or `niveau` like `{motCle}` ";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_recettes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "SAMdid781227");
            java.sql.Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sqlRecherche);
            
            while (rs.next())
            { 
              recettes.add(new Recette(rs.getInt("id_recette"), rs.getString("libelle"), rs.getString("niveau"), rs.getInt("duree_cuissant"), rs.getString("ingredients"), rs.getString("preparation")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return recettes;
    } 
}
