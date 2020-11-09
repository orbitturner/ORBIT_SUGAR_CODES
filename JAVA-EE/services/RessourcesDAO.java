/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Achat;
import beans.Article;
import beans.Client;
import beans.DetailEntree;
import beans.DetailVente;
import beans.Entree;
import beans.Fournisseur;
import beans.LocalisationArt;
import beans.Marque;
import beans.ProfileUser;
import beans.Stock;
import beans.TypeArticle;
import beans.TypeClient;
import beans.Utilisateur;
import beans.Vente;
import beans.Ventes;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mbaye
 */
public class RessourcesDAO {
    
    public static Utilisateur getUtilisateurByLogAndPass(String login,String pass) throws Exception
    {
        String sql="select * from utilisateur u,profileuser p where u.idProfile=p.idProfile AND u.login=? AND u.password=? AND u.visibilite=1";
        DBHelper db=DBHelper.getInstance();
        Utilisateur user=null;
        
        try {
           db.myPrepareStatement(sql);
           db.addParametres(1, login);
           db.addParametres(2, pass);
           ResultSet rs=db.myExecutePrepareQuery();
           while(rs.next())
           {
               user=new Utilisateur();
               user.setIdUser(rs.getInt(1));
               user.setNomUser(rs.getString(2));
               user.setPrenomUser(rs.getString(3));
               user.setEmailUser(rs.getString(4));
               user.setLogin(rs.getString(5));
               user.setPassword(rs.getString(6));
               user.setVisibilite(rs.getInt(7));
               user.setEtatCompte(rs.getInt(8));
               
               ProfileUser p=new ProfileUser();
               p.setIdProfile(rs.getInt(10));
               p.setNomProfile(rs.getString(11));
               user.setProfile(p);
               
           }
           rs.close();
        } catch (Exception ex) {
            throw ex;
        }
        return user;
    }
    public static List<TypeArticle> getTypeArticles() throws Exception
    {
        String sql="select * from typearticle where visibilite=1";
        List<TypeArticle> listeArticles=new ArrayList<>();
        try {
            DBHelper db=DBHelper.getInstance();
            ResultSet rs=db.myExecuteQuery(sql);
            while(rs.next())
            {
                TypeArticle typeart=new TypeArticle();
                typeart.setIdTypeArticle(rs.getInt(1));
                typeart.setNomTypeArticle(rs.getString(2));
                typeart.setVisibilite(rs.getInt(3));
                listeArticles.add(typeart);
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return listeArticles;
    }
    
    
    public static TypeArticle getTypeArticlesById(int id) throws Exception
    {
        String sql="select * from typearticle where idTypeArticle=? AND visibilite=1";
        TypeArticle t=new TypeArticle();
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, id);
            ResultSet rs=db.myExecutePrepareQuery();
            while(rs.next())
            {
                
                t.setIdTypeArticle(rs.getInt(1));
                t.setNomTypeArticle(rs.getString(2));
                t.setVisibilite(rs.getInt(3));
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return t;
    }
    public static TypeClient getTypeClientById(int id) throws Exception
    {
        String sql="select * from typeclient where idTypeClient=? AND visibilite=1";
        TypeClient t=new TypeClient();
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, id);
            ResultSet rs=db.myExecutePrepareQuery();
            while(rs.next())
            {
                
                t.setIdTypeClient(rs.getInt(1));
                t.setNomTypeClient(rs.getString(2));
                t.setVisibilite(rs.getInt(3));
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return t;
    }
    
    public static List<Article> getArticle() throws Exception
    {
       String sql="select * from article a,typearticle ta, marque m where a.idTypeArticle=ta.idTypeArticle AND a.idMarque=a.idMarque  AND m.visibilite=1 AND ta.visibilite=1 AND a.visibilite=1";
       List<Article> listeArticle=new ArrayList<>();
        try {
            DBHelper db=DBHelper.getInstance();
            ResultSet rs=db.myExecuteQuery(sql);
            while(rs.next())
            {
                Article a=new Article();
                a.setIdArticle(rs.getInt(1));
                a.setRefArticle(rs.getString(2));
                a.setDesignation(rs.getString(3));
                a.setVisibilite(rs.getInt(4));
                TypeArticle t=new TypeArticle();
                t.setIdTypeArticle(rs.getInt(7));
                t.setNomTypeArticle(rs.getString(8));
                t.setVisibilite(rs.getInt(9));
                a.setTypearticle(t);
                Marque m=new Marque();
                m.setIdMarque(rs.getInt(10));
                m.setNomMarque(rs.getString(11));
                m.setVisibilite(rs.getInt(12));
                a.setMarque(m);
                listeArticle.add(a);
                
            }
            rs.close();
        } catch (Exception e) {
            throw e;
            
        }
        return listeArticle;
    }
    public static void addTypearticle(TypeArticle t) throws Exception
    {
        String sql="insert into typearticle values(null,?,?)";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, t.getNomTypeArticle());
            db.addParametres(2, 1);
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    public static void addMarque(Marque m) throws Exception
    {
        String sql="insert into marque values(null,?,?)";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, m.getNomMarque());
            db.addParametres(2, 1);
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void addLocalisation(LocalisationArt l) throws Exception
    {
        String sql="insert into localisation values(null,?)";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, l.getNomLocalisation());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static List<Marque> getMarques() throws Exception
    {
        String sql="select * from marque where visibilite=1";
        List<Marque> lesMarques=new ArrayList<>();
        try {
            DBHelper db=DBHelper.getInstance();
            ResultSet rs=db.myExecuteQuery(sql);
            while(rs.next())
            {
                Marque m=new Marque();
                m.setIdMarque(rs.getInt(1));
                m.setNomMarque(rs.getString(2));
                m.setVisibilite(rs.getInt(3));
                lesMarques.add(m);
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return lesMarques;
    }
    public static void deleteMarque(Marque m) throws Exception
    {
        String sql="update marque set visibilite=0 where idMarque=?";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, m.getIdMarque());
        } catch (Exception e) {
            throw e;
        }
    }
    public static void updateMarque(Marque m) throws Exception
    {
        String sql="update marque set nomMarque=? where idMarque=?";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, m.getNomMarque());
            db.addParametres(2, m.getIdMarque());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    public static void updateLocalisation(LocalisationArt l) throws Exception
    {
        String sql="update localisation set nomLocalisation=? where idLocalisation=?";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, l.getNomLocalisation());
            db.addParametres(2, l.getIdLocalisation());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    public static void addArticle(Article a) throws Exception
    {
        String sql="insert into article values(null,?,?,?,?,?,?)";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, a.getRefArticle());
            db.addParametres(2, a.getDesignation());
            db.addParametres(3, 1);
            db.addParametres(4, a.getTypearticle().getIdTypeArticle());
            db.addParametres(5, a.getMarque().getIdMarque());
            db.addParametres(6, a.getLocalisation().getIdLocalisation());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static List<Client> getClient() throws Exception
    {
        String sql="select * from client c, typeclient t where t.idTypeClient=c.idTypeClient AND c.visibilite=1 AND t.visibilite=1 order by nomClient";
        List<Client> lesClients=new ArrayList<>();
        try {
            DBHelper db=DBHelper.getInstance();
            ResultSet rs=db.myExecuteQuery(sql);
            while(rs.next())
            {
                Client c=new Client();
                c.setIdClient(rs.getInt(1));
                c.setMatClient(rs.getString(2));
                c.setNomClient(rs.getString(3));
                c.setMobileClient(rs.getString(4));
                c.setFixClient(rs.getString(5));
                c.setAdresseClient(rs.getString(6));
                c.setEmailClient(rs.getString(7));
                c.setVisibilite(rs.getInt(8));
                TypeClient t=new TypeClient();
                t.setIdTypeClient(rs.getInt(10));
                t.setNomTypeClient(rs.getString(11));
                t.setVisibilite(rs.getInt(12));
                c.setTypeclient(t);
                lesClients.add(c);
            }
            rs.close();
            
        } catch (Exception e) {
            throw e;
        }
        return lesClients;
    }
    public static Client getClientById(int id) throws Exception
    {
        String sql="select * from client c, typeclient t where t.idTypeClient=c.idTypeClient AND c.visibilite=1 AND t.visibilite=1 AND idClient=?";
        Client c=null;
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, id);
            ResultSet rs=db.myExecutePrepareQuery();
            while(rs.next())
            {
                c=new Client();
                c.setIdClient(rs.getInt(1));
                c.setMatClient(rs.getString(2));
                c.setNomClient(rs.getString(3));
                c.setMobileClient(rs.getString(4));
                c.setFixClient(rs.getString(5));
                c.setAdresseClient(rs.getString(6));
                c.setEmailClient(rs.getString(7));
                c.setVisibilite(rs.getInt(8));
                TypeClient t=new TypeClient();
                t.setIdTypeClient(rs.getInt(10));
                t.setNomTypeClient(rs.getString(11));
                t.setVisibilite(rs.getInt(12));
                c.setTypeclient(t);
                
            }
            rs.close();
            
        } catch (Exception e) {
            throw e;
        }
        return c;
    }
    
    public static void addClient(Client c) throws Exception
    {
        String sql="insert into client values(null,?,?,?,?,?,?,?,?)";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, c.getMatClient());
            db.addParametres(2, c.getNomClient());
            db.addParametres(3, c.getMobileClient());
            db.addParametres(4, c.getFixClient());
            db.addParametres(5, c.getAdresseClient());
            db.addParametres(6, c.getEmailClient());
            db.addParametres(7, 1);
            db.addParametres(8, c.getTypeclient().getIdTypeClient());
            db.myExecutePrepareUpdate();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void addUtilisateur(Utilisateur user) throws Exception
    {
        String sql="insert into utilisateur values(null,?,?,?,?,?,?,?,?)";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, user.getNomUser().toUpperCase());
            db.addParametres(2, user.getPrenomUser());
            db.addParametres(3, user.getEmailUser());
            db.addParametres(4, user.getLogin());
            db.addParametres(5, user.getPassword());
            db.addParametres(6, 1);
            db.addParametres(7, 0);
            db.addParametres(8, user.getProfile().getIdProfile());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    public static Utilisateur getUtilisateurByLogin(String login) throws Exception
    {
        String sql="select * from utilisateur u,profileuser p where u.idProfile=p.idProfile AND u.login=? AND visibilite=1";
        DBHelper db=DBHelper.getInstance();
        Utilisateur user=null;
        
        try {
           db.myPrepareStatement(sql);
           db.addParametres(1, login);
           ResultSet rs=db.myExecutePrepareQuery();
           while(rs.next())
           {
               user=new Utilisateur();
               user.setIdUser(rs.getInt(1));
               user.setNomUser(rs.getString(2));
               user.setPrenomUser(rs.getString(3));
               user.setEmailUser(rs.getString(4));
               user.setLogin(rs.getString(5));
               user.setPassword(rs.getString(6));
               user.setVisibilite(rs.getInt(7));
               user.setEtatCompte(rs.getInt(8));
               
               
               ProfileUser p=new ProfileUser();
               p.setIdProfile(rs.getInt(10));
               p.setNomProfile(rs.getString(11));
               
               user.setProfile(p);
               
           }
           rs.close();
        } catch (Exception ex) {
            throw ex;
        }
        return user;
    }
    
    public static void addStock(Stock stock) throws Exception
    {
       String sql="insert into stock values(null,?,?,?)";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, stock.getQteInitial());
            db.addParametres(2, stock.getQteStock());
            db.addParametres(3, stock.getArticle().getIdArticle());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    public static Article getArticleByReference(String ref) throws Exception
    {
        String sql="select * from article a,typearticle ta,marque m,localisation l where l.idLocalisation=a.idLocalisation AND m.idMarque=a.idMarque AND a.idTypeArticle=ta.idTypeArticle and a.refArticle=? and a.visibilite=1 ";
        Article a=null;
        
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, ref);
            ResultSet rs=db.myExecutePrepareQuery();
             
            while(rs.next())
            {
                a=new Article();

                a.setIdArticle(rs.getInt(1));
                a.setRefArticle(rs.getString(2));
                a.setDesignation(rs.getString(3));
                a.setVisibilite(rs.getInt(4));
                TypeArticle t=new TypeArticle();
                t.setIdTypeArticle(rs.getInt(8));
                t.setNomTypeArticle(rs.getString(9));
                t.setVisibilite(rs.getInt(10));
                a.setTypearticle(t);
                Marque m=new Marque();
                m.setIdMarque(rs.getInt(11));
                m.setNomMarque(rs.getString(12));
                m.setVisibilite(rs.getInt(13));
                a.setMarque(m);
                LocalisationArt l=new LocalisationArt();
                l.setIdLocalisation(rs.getInt(14));
                l.setNomLocalisation(rs.getString(15));
                a.setLocalisation(l);
                
                
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        
        return a;
    }
    
    
    public static void deleteTypeArticle(TypeArticle type) throws Exception
    {
        String sql="update typearticle set visibilite=0 where idTypeArticle=?";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, type.getIdTypeArticle());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static List<TypeClient> getTypeClient() throws Exception
    {
        String sql="select * from typeclient where visibilite=1";
        List<TypeClient> listeType=new ArrayList<>();
        try {
            DBHelper db=DBHelper.getInstance();
            ResultSet rs=db.myExecuteQuery(sql);
            while(rs.next())
            {
                TypeClient typecli=new TypeClient();
                typecli.setIdTypeClient(rs.getInt(1));
                typecli.setNomTypeClient(rs.getString(2));
                typecli.setVisibilite(rs.getInt(3));
                listeType.add(typecli);
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return listeType;
    }
    
    public static void deleteClient(Client client) throws Exception
    {
        String sql="update client set visibilite=0 where idClient=?";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, client.getIdClient());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void deleteArticle(Article article) throws Exception
    {
        String sql="update article set visibilite=0 where idArticle=?";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, article.getIdArticle());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void updateArticle(Article article) throws Exception
    {
        String sql="update article set refArticle=?, Designation=?,idtypeArticle=?,idMarque=?,idLocalisation=? where idArticle=?";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, article.getRefArticle());
            db.addParametres(2, article.getDesignation());
            db.addParametres(3, article.getTypearticle().getIdTypeArticle());
            db.addParametres(4, article.getMarque().getIdMarque());
            db.addParametres(5, article.getLocalisation().getIdLocalisation());
            db.addParametres(6, article.getIdArticle());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void updateSelectedClient(Client client) throws Exception
    {
        String sql="update client set nomClient=?,telClient=?,fixeClient=?,adresseClient=?,emailClient=?,idTypeClient=? where idClient=?";
        DBHelper db=DBHelper.getInstance();
        try {
            
            db.myPrepareStatement(sql);
            db.addParametres(1, client.getNomClient());
            db.addParametres(2, client.getMobileClient());
            db.addParametres(3, client.getFixClient());
            db.addParametres(4, client.getAdresseClient());
            db.addParametres(5, client.getEmailClient());
            db.addParametres(6, client.getTypeclient().getIdTypeClient());
            db.addParametres(7, client.getIdClient());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void updateTypeArticle(TypeArticle ta)
    {
        String sql="update typearticle set nomTypeArticle=? where idTypeArticle=?";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, ta.getNomTypeArticle());
            db.addParametres(2, ta.getIdTypeArticle());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void updateTypeClient(TypeClient tc) throws Exception
    {
        String sql="update typeclient set nomTypeClient=? where idTypeClient=?";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, tc.getNomTypeClient());
            db.addParametres(2, tc.getIdTypeClient());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static String generateMatriculeFournisseur() throws Exception {
        DBHelper db=DBHelper.getInstance();
        int a = 0;
        ResultSet rs = db.myExecuteQuery("SELECT Max(idFournisseur) FROM fournisseur");
        if(rs.next())
        {
            a=rs.getInt(1);
        }
        NumberFormat nf = new DecimalFormat("0000");
        int b = a + 1;
        String matricule ="F"+ LocalDate.now().getYear()+LocalDate.now().getMonthValue()+LocalDate.now().getDayOfMonth()+"/"+ nf.format(b);
        return matricule;
    }
    public static String generateMatriculeClient() throws Exception {
        DBHelper db=DBHelper.getInstance();
        int a = 0;
        ResultSet rs = db.myExecuteQuery("SELECT Max(idClient) FROM client");
        if(rs.next())
        {
            a=rs.getInt(1);
        }
        NumberFormat nf = new DecimalFormat("0000");
        int b = a + 1;
        String matricule ="C"+ LocalDate.now().getYear()+LocalDate.now().getMonthValue()+LocalDate.now().getDayOfMonth()+"/"+ nf.format(b);
        return matricule;
    }
    public static String generateNumeroBR() throws Exception {
        DBHelper db=DBHelper.getInstance();
        int a = 0;
        ResultSet rs = db.myExecuteQuery("SELECT Max(idEntree) FROM entree");
        if(rs.next())
        {
            a=rs.getInt(1);
        }
        NumberFormat nf = new DecimalFormat("0000");
        int b = a + 1;
        String numBr ="BR"+ LocalDate.now().getYear()+LocalDate.now().getMonthValue()+LocalDate.now().getDayOfMonth()+"/"+ nf.format(b);
        return numBr;
    }
    public static String generateNumeroBS() throws Exception {
        DBHelper db=DBHelper.getInstance();
        int a = 0;
        ResultSet rs = db.myExecuteQuery("SELECT Max(idVente) FROM vente");
        if(rs.next())
        {
            a=rs.getInt(1);
        }
        NumberFormat nf = new DecimalFormat("000");
        int b = a + 1;
        String numeroSortie ="BS"+ LocalDate.now().getYear()+LocalDate.now().getMonthValue()+LocalDate.now().getDayOfMonth()+"/"+ nf.format(b);
        return numeroSortie;
    }
    public static void addFournisseur(Fournisseur f) throws Exception
    {
        String sql="insert into fournisseur values (null,?,?,?,?,?,?,?)";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, f.getMatFournisseur());
            db.addParametres(2, f.getNomFournisseur());
            db.addParametres(3, f.getMobileFournisseur());
            db.addParametres(4, f.getFixeFournisseur());
            db.addParametres(5, f.getAdresseFournisseur());
            db.addParametres(6, f.getEmailFournisseur());
            db.addParametres(7, 1);
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static List<Fournisseur> getFournisseurs() throws Exception
    {
        String sql="select * from fournisseur where visibilite=1";
        List<Fournisseur> fournisseurs=new ArrayList<>();
        try {
            DBHelper db=DBHelper.getInstance();
            ResultSet rs=db.myExecuteQuery(sql);
            while(rs.next())
            {
                Fournisseur f=new Fournisseur();
                f.setIdFournisseur(rs.getInt(1));
                f.setMatFournisseur(rs.getString(2));
                f.setNomFournisseur(rs.getString(3));
                f.setMobileFournisseur(rs.getString(4));
                f.setFixeFournisseur(rs.getString(5));
                f.setAdresseFournisseur(rs.getString(6));
                f.setEmailFournisseur(rs.getString(7));
                f.setVisibiliteFournisseur(rs.getInt(8));
                fournisseurs.add(f);
                
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return fournisseurs;
    }
    public static void updateFournisseur(Fournisseur f) throws Exception
    {
        String sql="update fournisseur set nomFournisseur=?,mobileFournisseur=?,fixeFournisseur=?,adresseFournisseur=?,emailFournisseur=? where idFournisseur=?";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, f.getNomFournisseur());
            db.addParametres(2, f.getMobileFournisseur());
            db.addParametres(3, f.getFixeFournisseur());
            db.addParametres(4, f.getAdresseFournisseur());
            db.addParametres(5, f.getEmailFournisseur());
            db.addParametres(6, f.getIdFournisseur());
           db.myExecutePrepareUpdate();
        } catch (Exception ex){
            throw ex;
        }
    }
    public static void deleteFournisseur(Fournisseur fourniseur) throws Exception
    {
        String sql="update fournisseur set visibilite=0 where idFournisseur=?";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, fourniseur.getIdFournisseur());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Fournisseur getFournisseurByMobile(String mobile) throws Exception
    {
        String sql="select * from fournisseur where mobileFournisseur=? ";
        Fournisseur f=null;
        
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, mobile);
            ResultSet rs=db.myExecutePrepareQuery();
             
            while(rs.next())
            {
                f=new Fournisseur();

                f.setIdFournisseur(rs.getInt(1));
                f.setMatFournisseur(rs.getString(2));
                f.setNomFournisseur(rs.getString(3));
                f.setMobileFournisseur(rs.getString(4));
                f.setFixeFournisseur(rs.getString(5));
                f.setAdresseFournisseur(rs.getString(6));
                f.setEmailFournisseur(rs.getString(7));
                f.setVisibiliteFournisseur(rs.getInt(8));   
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        
        return f;
    }
    
    public static Fournisseur getFournisseurByFixe(String fixe) throws Exception
    {
        String sql="select * from fournisseur where fixeFournisseur=? ";
        Fournisseur f=null;
        
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, fixe);
            ResultSet rs=db.myExecutePrepareQuery();
             
            while(rs.next())
            {
                f=new Fournisseur();

                f.setIdFournisseur(rs.getInt(1));
                f.setMatFournisseur(rs.getString(2));
                f.setNomFournisseur(rs.getString(3));
                f.setMobileFournisseur(rs.getString(4));
                f.setFixeFournisseur(rs.getString(5));
                f.setAdresseFournisseur(rs.getString(6));
                f.setEmailFournisseur(rs.getString(7));
                f.setVisibiliteFournisseur(rs.getInt(8));   
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        
        return f;
    }
    
    public static Fournisseur getFournisseurByEmail(String email) throws Exception
    {
        String sql="select * from fournisseur where emailFournisseur=? ";
        Fournisseur f=null;
        
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, email);
            ResultSet rs=db.myExecutePrepareQuery();
             
            while(rs.next())
            {
                f=new Fournisseur();

                f.setIdFournisseur(rs.getInt(1));
                f.setMatFournisseur(rs.getString(2));
                f.setNomFournisseur(rs.getString(3));
                f.setMobileFournisseur(rs.getString(4));
                f.setFixeFournisseur(rs.getString(5));
                f.setAdresseFournisseur(rs.getString(6));
                f.setEmailFournisseur(rs.getString(7));
                f.setVisibiliteFournisseur(rs.getInt(8));   
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        
        return f;
    }
    public static Fournisseur getFournisseurById(int id) throws Exception
    {
        String sql="select * from fournisseur where idFournisseur=? ";
        Fournisseur f=null;
        
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, id);
            ResultSet rs=db.myExecutePrepareQuery();
             
            while(rs.next())
            {
                f=new Fournisseur();

                f.setIdFournisseur(rs.getInt(1));
                f.setMatFournisseur(rs.getString(2));
                f.setNomFournisseur(rs.getString(3));
                f.setMobileFournisseur(rs.getString(4));
                f.setFixeFournisseur(rs.getString(5));
                f.setAdresseFournisseur(rs.getString(6));
                f.setEmailFournisseur(rs.getString(7));
                f.setVisibiliteFournisseur(rs.getInt(8));   
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        
        return f;
    }
    
    public static void addEntree(Entree e) throws Exception
    {
        DBHelper db=DBHelper.getInstance();
        String sql="insert into entree values (null,?,?,?,?,?)";
        try {
            
            db.myPrepareStatement(sql);
            db.addParametres(1, e.getNumeroEntree());
            db.addParametres(2, e.getDateEntree().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            db.addParametres(3, e.getSommeEntree());
            db.addParametres(4, e.getAvoir());
            db.addParametres(5, e.getFournisseur().getIdFournisseur());
            db.myExecutePrepareUpdate();
        } catch (Exception ex) {
            throw ex;
        }
        
    }
    
    public static void addDetailEntree(DetailEntree de) throws Exception
    {
        DBHelper db=DBHelper.getInstance();
        String sql="insert into detailentree values (?,?,?,?)";
        try {
            
            db.myPrepareStatement(sql);
            db.addParametres(1, de.getEntree().getIdEntree());
            db.addParametres(2, de.getArticle().getIdArticle());
            db.addParametres(3, de.getQteEntree());
            db.addParametres(4, de.getPuEntree());
            db.myExecutePrepareUpdate();
        } catch (Exception ex) {
            throw ex;
        }
        
    }
    
    public static Entree getEntreeByNumero(String numero) throws Exception
    {
        String sql="select * from entree where numeroEntree=? ";
        Entree en=null;
        
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, numero);
            ResultSet rs=db.myExecutePrepareQuery();
             
            while(rs.next())
            {
                en=new Entree();
                en.setIdEntree(rs.getInt(1));
                en.setNumeroEntree(rs.getString(2));
                en.setDateEntree(rs.getDate(3).toLocalDate());
            }
            rs.close();
        } catch (Exception ex) {
            throw ex;
        }
        
        return en;
    }
    public static int getQteStockByIdMax(int idmax) throws Exception
    {
        String sql="select qteStock from stock where idStock=?";
        DBHelper db=DBHelper.getInstance();
        int qteStock=0;
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, idmax);
            ResultSet rs=db.myExecutePrepareQuery();
            if(rs.next())
            {
                qteStock=rs.getInt(1);
            }
            
        } catch (Exception e) {
            throw e;
        }
        return qteStock;
    }
    
    public static void incrementerStock(int qteInitial, int newValue,Article article) throws Exception
    {
        String sql="update stock set qteInitial=?,qteStock=? where idArticle=?";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, qteInitial);
            db.addParametres(2, qteInitial+newValue);
            db.addParametres(3, article.getIdArticle());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void addVente(Vente v) throws Exception
    {
        DBHelper db=DBHelper.getInstance();
        String sql="insert into vente values (null,?,?,?,?,?,?)";
        try {
            
            db.myPrepareStatement(sql);
            db.addParametres(1, v.getNumeroVente());
            db.addParametres(2, v.getDateVente().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            db.addParametres(3, v.getSommeVente());
            db.addParametres(4, v.getAvoir());
            db.addParametres(5, v.getClient().getIdClient());
            db.addParametres(6, v.getUtilisateur().getIdUser());
            db.myExecutePrepareUpdate();
        } catch (Exception ex) {
            throw ex;
        }
        
    }
    
    public static void decrementerStock(int qteStock, int newValue,int idmax) throws Exception
    {
        String sql="update stock set qteStock=? where idStock=?";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, (qteStock - newValue));
            db.addParametres(2, idmax);
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Vente getVenteByNumero(String numero) throws Exception
    {
        String sql="select * from vente,client,utilisateur where vente.idClient=client.idClient AND vente.idUser=utilisateur.idUser AND numeroVente=? ";
        Vente v=null;
        
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, numero);
            ResultSet rs=db.myExecutePrepareQuery();
             
            while(rs.next())
            {
                v=new Vente();
                v.setIdVente(rs.getInt(1));
                v.setNumeroVente(rs.getString(2));
                v.setDateVente(rs.getDate(3).toLocalDate());
                v.setSommeVente(rs.getInt(4));
                v.setAvoir(rs.getInt(5));
                Client c=new Client();
                c.setIdClient(rs.getInt(8));
                c.setMatClient(rs.getString(9));
                c.setNomClient(rs.getString(10));
                c.setMobileClient(rs.getString(11));
                c.setFixClient(rs.getString(12));
                c.setAdresseClient(rs.getString(13));
                c.setEmailClient(rs.getString(14));
                c.setVisibilite(rs.getInt(15));
                c.setTypeclient(RessourcesDAO.getTypeClientById(rs.getInt(16)));
                v.setClient(c);
                Utilisateur u=new Utilisateur();
                u.setIdUser(rs.getInt(17));
                u.setNomUser(rs.getString(18));
                u.setPrenomUser(rs.getString(19));
                u.setEmailUser(rs.getString(20));
                v.setUtilisateur(u);
            }
            rs.close();
        } catch (Exception ex) {
            throw ex;
        }
        
        return v;
    }
    
    public static void addDetailVente(DetailVente dv) throws Exception
    {
        DBHelper db=DBHelper.getInstance();
        String sql="insert into detailvente values (?,?,?,?)";
        try {
            
            db.myPrepareStatement(sql);
            db.addParametres(1, dv.getArticle().getIdArticle());
            db.addParametres(2, dv.getVente().getIdVente());
            db.addParametres(3, dv.getQteVendue());
            db.addParametres(4, dv.getPrix());
            db.myExecutePrepareUpdate();
        } catch (Exception ex) {
            throw ex;
        }
        
    }
    
    public static List<Integer> getListIdMax()
    {
        List<Integer> idMaxList=new ArrayList<>();
        String sql="select Max(idStock) from stock,article where stock.idArticle=article.idArticle AND article.visibilite=1 group by article.idArticle";
        try {
            DBHelper db=DBHelper.getInstance();
            ResultSet rs=db.myExecuteQuery(sql);
            while(rs.next())
            {
                idMaxList.add(rs.getInt(1));
            }
            rs.close();
        } catch (Exception e) {
        }
        return idMaxList;
    }
    public static int getIdMax(Article article)
    {

        String sql="select Max(idStock) from stock s,article a where s.idArticle=a.idArticle AND a.idArticle=?";
        int id=0;
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, article.getIdArticle());
            ResultSet rs=db.myExecutePrepareQuery();
            if(rs.next())
            {
                id=rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
        }
        return id;
       
    }
    
    public static List<Article> getArticleMax() throws Exception
    {
        
        List<Article> articles=new ArrayList<>();
        List<Integer> idmax=RessourcesDAO.getListIdMax();
        try {
            for(int i=0;i<idmax.size();i++)
            {
                articles.add(getArticleByIdMax(idmax.get(i)));
            }
                
        } catch (Exception e) {
        }
        return articles;
    }
    
    public static Article getArticleByIdMax(int idMax) throws Exception
    {
        String sql="select * from article a,typearticle ta, marque m,stock s,localisation l where l.idLocalisation=a.idLocalisation AND a.idTypeArticle=ta.idTypeArticle AND a.idMarque=m.idMarque AND a.idArticle=s.idArticle AND m.visibilite=1 AND ta.visibilite=1 AND a.visibilite=1 AND s.idStock=?";
        Article a=null;
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, idMax);
            ResultSet rs=db.myExecutePrepareQuery();
                while(rs.next())
                {
                    a=new Article();
                a.setIdArticle(rs.getInt(1));
                a.setRefArticle(rs.getString(2));
                a.setDesignation(rs.getString(3));
                a.setVisibilite(rs.getInt(4));
                TypeArticle t=new TypeArticle();
                t.setIdTypeArticle(rs.getInt(8));
                t.setNomTypeArticle(rs.getString(9));
                t.setVisibilite(rs.getInt(10));
                a.setTypearticle(t);
                Marque m=new Marque();
                m.setIdMarque(rs.getInt(6));
                m.setNomMarque(rs.getString(12));
                m.setVisibilite(rs.getInt(13));
                a.setQteInitial(rs.getInt(15));
                a.setQteStock(rs.getInt(16));
                a.setQteMin(rs.getInt(17));
                a.setMarque(m);
                LocalisationArt l=new LocalisationArt();
                l.setIdLocalisation(rs.getInt(18));
                l.setNomLocalisation(rs.getString(19));
                a.setLocalisation(l);
                
                }
                rs.close();
            
        } catch (Exception e) {
            throw e;
        }
        return a;
        
    }
    

    public static Article verifyUpdateArticleByReference(String ref1,String ref2) throws Exception
    {
        String sql="select * from article a,typearticle ta,marque m where m.idMarque=a.idMarque AND a.idTypeArticle=ta.idTypeArticle and a.refArticle=? and a.refArticle<>? and a.visibilite=1 ";
        Article a=null;
        
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, ref2);
            db.addParametres(2, ref1);
            ResultSet rs=db.myExecutePrepareQuery();
             
            while(rs.next())
            {
                a=new Article();

                a.setIdArticle(rs.getInt(1));
                a.setRefArticle(rs.getString(2));
                a.setDesignation(rs.getString(3));
                a.setVisibilite(rs.getInt(4));
                TypeArticle t=new TypeArticle();
                t.setIdTypeArticle(rs.getInt(7));
                t.setNomTypeArticle(rs.getString(8));
                t.setVisibilite(rs.getInt(9));
                a.setTypearticle(t);
                Marque m=new Marque();
                m.setIdMarque(rs.getInt(10));
                m.setNomMarque(rs.getString(11));
                m.setVisibilite(rs.getInt(12));
                a.setMarque(m);
                
                
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        
        return a;
    }
    
    public static List<Achat> getAchats() throws Exception
    {
        List<Achat> listeAchats=new ArrayList<>();
        DBHelper db=DBHelper.getInstance();
        String sql="SELECT numeroEntree,dateEntree,refArticle,Designation,SUM(qteEntree),puEntree,idFournisseur FROM entree,`detailentree`,article WHERE entree.idEntree=detailentree.idEntree AND detailentree.idArticle=article.idArticle GROUP BY entree.numeroEntree,entree.dateEntree,Designation,refArticle,puEntree,idFournisseur";
        try {
            
            ResultSet rs=db.myExecuteQuery(sql);
            while(rs.next())
            {
                Achat achat=new Achat();
                achat.setNumAchat(rs.getString(1));
                achat.setDateAchat(rs.getDate(2).toLocalDate());
                achat.setRefArticle(rs.getString(3));
                achat.setDesignation(rs.getString(4));
                achat.setQteArticle(rs.getInt(5));
                achat.setPuArticle(rs.getInt(6));
                achat.setMontant(rs.getInt(5)*rs.getInt(6));
                achat.setFournisseur(getFournisseurById(rs.getInt(7)));
                listeAchats.add(achat);
                
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return listeAchats;
    }
    
    public static List<Achat> getAchatsByDate(LocalDate date) throws Exception
    {
        List<Achat> listeAchats=new ArrayList<>();
        String sql="SELECT numeroEntree,dateEntree,refArticle,Designation,SUM(qteEntree),puEntree,idFournisseur FROM entree,`detailentree`,article WHERE entree.idEntree=detailentree.idEntree AND detailentree.idArticle=article.idArticle AND entree.dateEntree=? GROUP BY entree.numeroEntree,entree.dateEntree,Designation,refArticle,puEntree,idFournisseur";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            ResultSet rs=db.myExecutePrepareQuery();
            while(rs.next())
            {
                Achat achat=new Achat();
                achat.setNumAchat(rs.getString(1));
                achat.setDateAchat(rs.getDate(2).toLocalDate());
                achat.setRefArticle(rs.getString(3));
                achat.setDesignation(rs.getString(4));
                achat.setQteArticle(rs.getInt(5));
                achat.setPuArticle(rs.getInt(6));
                achat.setMontant(rs.getInt(5)*rs.getInt(6));
                achat.setFournisseur(getFournisseurById(rs.getInt(7)));
                listeAchats.add(achat);
                
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return listeAchats;
    }
    
    public static List<LocalisationArt> getLocalisations() throws Exception
    {
        String sql="select * from localisation";
        List<LocalisationArt> localisations=new ArrayList<>();
        try {
            DBHelper db=DBHelper.getInstance();
            ResultSet rs=db.myExecuteQuery(sql);
            while(rs.next())
            {
                LocalisationArt l=new LocalisationArt();
                l.setIdLocalisation(rs.getInt(1));
                l.setNomLocalisation(rs.getString(2));
                localisations.add(l);
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return localisations;
    }
    
    public static Article getArticleRuptureByIdMax(int idMax) throws Exception
    {
        String sql="select * from article a,typearticle ta, marque m,stock s,localisation l where l.idLocalisation=a.idLocalisation AND a.idTypeArticle=ta.idTypeArticle AND a.idMarque=a.idMarque AND a.idArticle=s.idArticle AND m.visibilite=1 AND ta.visibilite=1 AND a.visibilite=1 AND s.qteStock=0 AND s.idStock=?";
        Article a=null;
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, idMax);
            ResultSet rs=db.myExecutePrepareQuery();
                while(rs.next())
                {
                    a=new Article();
                a.setIdArticle(rs.getInt(1));
                a.setRefArticle(rs.getString(2));
                a.setDesignation(rs.getString(3));
                a.setVisibilite(rs.getInt(4));
                TypeArticle t=new TypeArticle();
                t.setIdTypeArticle(rs.getInt(8));
                t.setNomTypeArticle(rs.getString(9));
                t.setVisibilite(rs.getInt(10));
                a.setTypearticle(t);
                Marque m=new Marque();
                m.setIdMarque(rs.getInt(11));
                m.setNomMarque(rs.getString(12));
                m.setVisibilite(rs.getInt(13));
                a.setQteInitial(rs.getInt(15));
                a.setQteStock(rs.getInt(16));
                a.setQteMin(rs.getInt(17));
                a.setMarque(m);
                LocalisationArt l=new LocalisationArt();
                l.setIdLocalisation(rs.getInt(18));
                l.setNomLocalisation(rs.getString(19));
                a.setLocalisation(l);
                
                }
                rs.close();
            
        } catch (Exception e) {
            throw e;
        }
        return a;
        
    }
    
        public static List<Article> getArticleRuptureMax() throws Exception
    {
        
        List<Article> articles=new ArrayList<>();
        List<Integer> idmax=RessourcesDAO.getListIdMax();
        try {
            for(int i=0;i<idmax.size();i++)
            {
                if(RessourcesDAO.getArticleRuptureByIdMax(idmax.get(i))!=null)
                {
                    articles.add(getArticleRuptureByIdMax(idmax.get(i)));
                }
            }
                
        } catch (Exception e) {
        }
        return articles;
    }
        
        
    public static List<Ventes> getVentes() throws Exception
    {
        List<Ventes> listeVentes=new ArrayList<>();
        DBHelper db=DBHelper.getInstance();
        String sql="SELECT numeroVente,dateVente,refArticle,Designation,SUM(qteVendue),puArticle,idClient FROM vente,`detailvente`,article WHERE vente.idVente=detailvente.idVente AND detailvente.idArticle=article.idArticle GROUP BY vente.numeroVente,vente.dateVente,Designation,refArticle,puArticle,idClient";
        try {
            
            ResultSet rs=db.myExecuteQuery(sql);
            while(rs.next())
            {
                Ventes ventes=new Ventes();
                ventes.setNumVente(rs.getString(1));
                ventes.setDateVente(rs.getDate(2).toLocalDate());
                ventes.setRefArt(rs.getString(3));
                ventes.setDesignation(rs.getString(4));
                ventes.setQteVendu(rs.getInt(5));
                ventes.setPuArt(rs.getInt(6));
                ventes.setMontant(rs.getInt(5)*rs.getInt(6));
                ventes.setClient(getClientById(rs.getInt(7)));
                listeVentes.add(ventes);
                
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return listeVentes;
    }
    
    public static void addTypeClient(TypeClient t) throws Exception
    {
        String sql="insert into typeclient values(null,?,?)";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, t.getNomTypeClient());
            db.addParametres(2, 1);
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public static List<Vente> getHistoriqueVente() throws Exception
    {
        String sql="select * from vente,client,utilisateur where vente.idClient=client.idClient AND vente.idUser=utilisateur.idUser";
        List<Vente> historiqueVente=new ArrayList<>();

        try {
            DBHelper db=DBHelper.getInstance();
            ResultSet rs=db.myExecuteQuery(sql);
             
            while(rs.next())
            {
                Vente v=new Vente();
                v.setIdVente(rs.getInt(1));
                v.setNumeroVente(rs.getString(2));
                v.setDateVente(rs.getDate(3).toLocalDate());
                v.setSommeVente(rs.getInt(4));
                v.setAvoir(rs.getInt(5));
                Client c=new Client();
                c.setIdClient(rs.getInt(8));
                c.setMatClient(rs.getString(9));
                c.setNomClient(rs.getString(10));
                c.setMobileClient(rs.getString(11));
                c.setFixClient(rs.getString(12));
                c.setAdresseClient(rs.getString(13));
                c.setEmailClient(rs.getString(14));
                c.setVisibilite(rs.getInt(15));
                c.setTypeclient(RessourcesDAO.getTypeClientById(rs.getInt(16)));
                v.setClient(c);
                Utilisateur u=new Utilisateur();
                u.setIdUser(rs.getInt(17));
                u.setNomUser(rs.getString(18));
                u.setPrenomUser(rs.getString(19));
                u.setEmailUser(rs.getString(20));
                v.setUtilisateur(u);
                historiqueVente.add(v);
            }
            rs.close();
        } catch (Exception ex) {
            throw ex;
        }
        
        return historiqueVente;
    }
    
    public static List<Entree> getEntree() throws Exception
    {
        List<Entree> entrees=new ArrayList<>();
        String sql="select * from entree,fournisseur where entree.idFournisseur=fournisseur.idFournisseur ";
        
        try {
            DBHelper db=DBHelper.getInstance();
            ResultSet rs=db.myExecuteQuery(sql);
             
            while(rs.next())
            {
                Entree en=new Entree();
                en.setIdEntree(rs.getInt(1));
                en.setNumeroEntree(rs.getString(2));
                en.setDateEntree(rs.getDate(3).toLocalDate());
                en.setSommeEntree(rs.getInt(4));
                en.setAvoir(rs.getInt(5));
                Fournisseur f=new Fournisseur();
                f.setIdFournisseur(rs.getInt(7));
                f.setMatFournisseur(rs.getString(8));
                f.setNomFournisseur(rs.getString(9));
                f.setMobileFournisseur(rs.getString(10));
                f.setFixeFournisseur(rs.getString(11));
                f.setAdresseFournisseur(rs.getString(12));
                f.setEmailFournisseur(rs.getString(13));
                f.setVisibiliteFournisseur(rs.getInt(14));
                en.setFournisseur(f);
                entrees.add(en);
            }
            rs.close();
        } catch (Exception ex) {
            throw ex;
        }
        
        return entrees;
    }
    
    
    public static List<Entree> getEntreesDate(LocalDate date) throws Exception
    {
        List<Entree> entrees=new ArrayList<>();
        String sql="select * from entree,fournisseur where entree.idFournisseur=fournisseur.idFournisseur AND entree.dateEntree=?";
        
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1,date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            ResultSet rs=db.myExecutePrepareQuery();
             
            while(rs.next())
            {
                Entree en=new Entree();
                en.setIdEntree(rs.getInt(1));
                en.setNumeroEntree(rs.getString(2));
                en.setDateEntree(rs.getDate(3).toLocalDate());
                en.setSommeEntree(rs.getInt(4));
                en.setAvoir(rs.getInt(5));
                Fournisseur f=new Fournisseur();
                f.setIdFournisseur(rs.getInt(7));
                f.setMatFournisseur(rs.getString(8));
                f.setNomFournisseur(rs.getString(9));
                f.setMobileFournisseur(rs.getString(10));
                f.setFixeFournisseur(rs.getString(11));
                f.setAdresseFournisseur(rs.getString(12));
                f.setEmailFournisseur(rs.getString(13));
                f.setVisibiliteFournisseur(rs.getInt(14));
                en.setFournisseur(f);
                entrees.add(en);
            }
            rs.close();
        } catch (Exception ex) {
            throw ex;
        }
        
        return entrees;
    }
    
    public static void reglerClient(Vente v,int sommeAreglee) throws Exception
    {
        String sql="update vente set avoir=? where idVente=?";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, v.getAvoir()-sommeAreglee);
            db.addParametres(2, v.getIdVente());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void reglerFournisseur(Entree en,int sommeAreglee) throws Exception
    {
        String sql="update entree set avoir=? where idEntree=?";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, en.getAvoir()-sommeAreglee);
            db.addParametres(2, en.getIdEntree());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static List<Utilisateur> getUtilisateurActifs() throws Exception
    {
        String sql="select * from utilisateur u,profileuser p where u.idProfile=p.idProfile AND u.visibilite=1 AND u.etatCompte=1";
        DBHelper db=DBHelper.getInstance();
        List<Utilisateur> usersActifs=new ArrayList<>();
        
        try {
           
           ResultSet rs=db.myExecuteQuery(sql);
           while(rs.next())
           {
               Utilisateur user=new Utilisateur();
               user.setIdUser(rs.getInt(1));
               user.setNomUser(rs.getString(2));
               user.setPrenomUser(rs.getString(3));
               user.setEmailUser(rs.getString(4));
               user.setLogin(rs.getString(5));
               user.setPassword(rs.getString(6));
               user.setVisibilite(rs.getInt(7));
               user.setEtatCompte(rs.getInt(8));
               
               ProfileUser p=new ProfileUser();
               p.setIdProfile(rs.getInt(10));
               p.setNomProfile(rs.getString(11));
               user.setProfile(p);
               usersActifs.add(user);
               
           }
           rs.close();
        } catch (Exception ex) {
            throw ex;
        }
        return usersActifs;
    }
    
    
    public static List<Utilisateur> getUtilisateurInactifs() throws Exception
    {
        String sql="select * from utilisateur u,profileuser p where u.idProfile=p.idProfile AND u.visibilite=1 AND u.etatCompte=0";
        DBHelper db=DBHelper.getInstance();
        List<Utilisateur> usersActifs=new ArrayList<>();
        
        try {
           
           ResultSet rs=db.myExecuteQuery(sql);
           while(rs.next())
           {
               Utilisateur user=new Utilisateur();
               user.setIdUser(rs.getInt(1));
               user.setNomUser(rs.getString(2));
               user.setPrenomUser(rs.getString(3));
               user.setEmailUser(rs.getString(4));
               user.setLogin(rs.getString(5));
               user.setPassword(rs.getString(6));
               user.setVisibilite(rs.getInt(7));
               user.setEtatCompte(rs.getInt(8));
               
               ProfileUser p=new ProfileUser();
               p.setIdProfile(rs.getInt(10));
               p.setNomProfile(rs.getString(11));
               user.setProfile(p);
               usersActifs.add(user);
               
           }
           rs.close();
        } catch (Exception ex) {
            throw ex;
        }
        return usersActifs;
    }
    
    public static void deleteUser(Utilisateur user) throws Exception
    {
        String sql="update utilisateur set visibilite=? where idUser=?";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, 0);
            db.addParametres(2, user.getIdUser());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void activerCompteUser(Utilisateur user) throws Exception
    {
        String sql="update utilisateur set etatCompte=? where idUser=?";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, 1);
            db.addParametres(2, user.getIdUser());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void desactiverCompteUser(Utilisateur user) throws Exception
    {
        String sql="update utilisateur set etatCompte=? where idUser=?";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, 0);
            db.addParametres(2, user.getIdUser());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    public static void setAdminUser(Utilisateur user) throws Exception
    {
        String sql="update utilisateur set idProfile=? where idUser=?";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, 1);
            db.addParametres(2, user.getIdUser());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    public static void setCaissierUser(Utilisateur user) throws Exception
    {
        String sql="update utilisateur set idProfile=? where idUser=?";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, 2);
            db.addParametres(2, user.getIdUser());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static List<Utilisateur> getAllUsers() throws Exception
    {
        String sql="select * from utilisateur u,profileuser p where u.idProfile=p.idProfile AND u.visibilite=1";
        DBHelper db=DBHelper.getInstance();
        List<Utilisateur> usersActifs=new ArrayList<>();
        
        try {
           
           ResultSet rs=db.myExecuteQuery(sql);
           while(rs.next())
           {
               Utilisateur user=new Utilisateur();
               user.setIdUser(rs.getInt(1));
               user.setNomUser(rs.getString(2));
               user.setPrenomUser(rs.getString(3));
               user.setEmailUser(rs.getString(4));
               user.setLogin(rs.getString(5));
               user.setPassword(rs.getString(6));
               user.setVisibilite(rs.getInt(7));
               user.setEtatCompte(rs.getInt(8));
               
               ProfileUser p=new ProfileUser();
               p.setIdProfile(rs.getInt(10));
               p.setNomProfile(rs.getString(11));
               user.setProfile(p);
               usersActifs.add(user);
               
           }
           rs.close();
        } catch (Exception ex) {
            throw ex;
        }
        return usersActifs;
    }
    
    public static List<Vente> getHistoriqueVenteByDate(LocalDate date) throws Exception
    {
        String sql="select * from vente,client,utilisateur where vente.idClient=client.idClient AND vente.idUser=utilisateur.idUser AND vente.dateVente=?";
        List<Vente> historiqueVente=new ArrayList<>();

        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            ResultSet rs=db.myExecutePrepareQuery();
             
            while(rs.next())
            {
                Vente v=new Vente();
                v.setIdVente(rs.getInt(1));
                v.setNumeroVente(rs.getString(2));
                v.setDateVente(rs.getDate(3).toLocalDate());
                v.setSommeVente(rs.getInt(4));
                v.setAvoir(rs.getInt(5));
                Client c=new Client();
                c.setIdClient(rs.getInt(8));
                c.setMatClient(rs.getString(9));
                c.setNomClient(rs.getString(10));
                c.setMobileClient(rs.getString(11));
                c.setFixClient(rs.getString(12));
                c.setAdresseClient(rs.getString(13));
                c.setEmailClient(rs.getString(14));
                c.setVisibilite(rs.getInt(15));
                c.setTypeclient(RessourcesDAO.getTypeClientById(rs.getInt(16)));
                v.setClient(c);
                Utilisateur u=new Utilisateur();
                u.setIdUser(rs.getInt(17));
                u.setNomUser(rs.getString(18));
                u.setPrenomUser(rs.getString(19));
                u.setEmailUser(rs.getString(20));
                v.setUtilisateur(u);
                historiqueVente.add(v);
            }
            rs.close();
        } catch (Exception ex) {
            throw ex;
        }
        
        return historiqueVente;
    }
    
    public static List<Ventes> getVentesByDate(LocalDate date) throws Exception
    {
        List<Ventes> listeVentes=new ArrayList<>();
        String sql="SELECT numeroVente,dateVente,refArticle,Designation,SUM(qteVendue),puArticle,idClient FROM vente,`detailvente`,article WHERE vente.idVente=detailvente.idVente AND detailvente.idArticle=article.idArticle AND vente.dateVente=? GROUP BY vente.numeroVente,vente.dateVente,Designation,refArticle,puArticle,idClient";
        try {
            DBHelper db=DBHelper.getInstance();
            db.myPrepareStatement(sql);
            db.addParametres(1, date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            ResultSet rs=db.myExecutePrepareQuery();
            while(rs.next())
            {
                Ventes ventes=new Ventes();
                ventes.setNumVente(rs.getString(1));
                ventes.setDateVente(rs.getDate(2).toLocalDate());
                ventes.setRefArt(rs.getString(3));
                ventes.setDesignation(rs.getString(4));
                ventes.setQteVendu(rs.getInt(5));
                ventes.setPuArt(rs.getInt(6));
                ventes.setMontant(rs.getInt(5)*rs.getInt(6));
                ventes.setClient(getClientById(rs.getInt(7)));
                listeVentes.add(ventes);
                
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        }
        return listeVentes;
    }
    
    public static List<Article> getArticleMaxByIdCategorie(int id) throws Exception
    {
        
        List<Article> articles=new ArrayList<>();
        List<Article> articleMax=RessourcesDAO.getArticleMax();
        try {
            for(int i=0;i<articleMax.size();i++)
            {
                if(articleMax.get(i).getTypearticle().getIdTypeArticle()==id)
                {
                    articles.add(articleMax.get(i));
                }
            }
                
        } catch (Exception e) {
        }
        return articles;
    }
    
    public static List<Article> getArticleRuptureMaxByIdCategorie(int id) throws Exception
    {
        
        List<Article> articles=new ArrayList<>();
        List<Article> articlerupture=RessourcesDAO.getArticleRuptureMax();
        try {
            for(int i=0;i<articlerupture.size();i++)
            {
                if(articlerupture.get(i).getTypearticle().getIdTypeArticle()==id)
                {
                    articles.add(articlerupture.get(i));
                }
            }
                
        } catch (Exception e) {
        }
        return articles;
    }
    
    public static void editPasswordUser(Utilisateur user) throws Exception
    {
        String sql="update utilisateur set password=? where idUser=?";
        DBHelper db=DBHelper.getInstance();
        try {
            db.myPrepareStatement(sql);
            db.addParametres(1, user.getPassword());
            db.addParametres(2, user.getIdUser());
            db.myExecutePrepareUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
}


