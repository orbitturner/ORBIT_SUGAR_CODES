<!--===============================================================================================-->	
<!-- *************ORBIT DEALING WEBSITE -- Version 1.2.0 -- PARTIE VERIFICATION LOGIN -->
<!--===============================================================================================-->	
<?php
session_start(); //CONEXION
    if (isset($_POST['submit'])){
			// Bon le try est le catch fonctionnent de cette façon : 
			// ce qui est dans le try s'execute en premier et si je dis bien s'il y'a un erreur il va rentrer dans le catch et tu vois bien il y'a un die dans le catch qui permet d'arreter l'execution
			try
			{
				$bdd = new PDO('mysql:host=localhost;dbname=testlog;charset=utf8', 'root', '@Orbitrix1064997', array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
				//Je lance une requete pour ouvrir ma base de donnée et sur dbname, je dois mettre le nom de ma base
				// la partie array permet de specifier exactement en cas d'erreur là où elle se trouve

			}
			catch(Exception $e)
			{
				die('Erreur : '.$e->getMessage());

			}
			$uname = $_POST['email'];
			$pseudo = $_POST['email'];
			$password = $_POST['pass'];
			// jusqu'a la c'est bon je pense
			// D'abord il y'a plusieurs façon de lancer la requete mais moi Dans ma requete je vais lui dire 
			// d'aller dans la table loginform et de chercher une personne dont l'username soit egale a celui qui est dans le $_POST et le mot de passe pareillement.
			// Dans le where, username et password doivent ecrit comme ça dans la base et dans le meme ordre donc c'est a toi de modifier la requete selon le nom de tes champs
			$reponse = $bdd->query("SELECT * FROM loginform where User='$uname' OR Pseudo='$pseudo' AND Pass='$password'");
			//maintenant il y'a deux possiblité soit $reponse est false ce qui veut dire que cette personne n'existe pas, soit elle est true ce qui veut dire qu'il a trouver la personne
			// Maintenant $personne contient la personne que je cherche mais les données sont rangées de maniere desordonner puisqu'il provienne directement de la base. Pour pouvoir exploiter ces données je vais faire un fetch qui veut dire va me chercher comme son nom l'indique en anglais. 
			$donnees = $reponse->fetch();
			
			// Apres le fetch maintenant chaque $donnees aura comme valeur Une ligne entiere de la base. Ce qui veut dire que si je fait $données['email'], j'aurais l'email de la personne qui est presente dans la base.
			if($donnees != false)//Si j'ai eu une personne renvoie moi vers la page acceuil
			{
				// $_SESSION['profil'] = 'admin';
				$_SESSION = $donnees;
				// Ici aussi puisque j'ai eu la personne je pourrais faire $_SESSION = $données
				// Comme ça j'aurais toute les données de l'utilisateurs quand je le voudrais au lieu de tout le temps retourner a la base.
				
				header('location:../../../index.php');
			}
			else{
				header('location:index.php?nolog=1');
				// $text1 = "NOT LOGGED IN";
				// $nolog = true;
				// echo("NOT LOGGED IN");
			}
			//Maintenant que j'ai fini je vais fermer ma base avec la reqquete suvante.
			$reponse->closeCursor();
	}
	//--------------L O G I N G  --  O U T-------------------
	if (isset($_GET['logout']) AND $_GET['logout'] == 1) {
		session_unset();
		$_SESSION = array();
		header('location:/ORBITTECHSHOP/index.php');
	
	}
?>