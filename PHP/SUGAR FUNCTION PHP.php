========| DOCTRINE ORM |=========
// database configuration parameters
$conn = array(
    'dbname'     => 'root',  
    'user'       => 'root',  
    'password'   => '',  
    'host'       => '127.0.0.1',  
    'driver'     => 'pdo_mysql',
    'path' => __DIR__ . '/db.sqlite',
);

// ======| ANNOTATION |======
	//TUTO Doctrine ORM
	https://www.youtube.com/watch?v=qyDK8HJHyoY&list=PLzT281RbfHAbIqrQomb1fXoMF8kRHbW90&index=10
	//Documentation Doctrine ORM
	https://www.doctrine-project.org/projects/doctrine-orm/en/2.7/tutorials/getting-started.html#getting-started-with-doctrine
	http://ormcheatsheet.com/
use Doctrine\ORM\Annotation as ORM;
use Doctrine\Common\Collections\ArrayCollection;

/**
 * @Entity @Table(name="client")
 **/
 
         /** @Id @Column(type="integer") @GeneratedValue **/

// **** + CMD + ****
 vendor/bin/doctrine orm:schema-tool:create --dump-sql
 vendor/bin/doctrine orm:schema-tool:create --force
 
// 🔹🔹🔹🔹🔹🔹🔹 CRUD DOCTRINE 🔹🔹🔹🔹🔹🔹🔹
	// Create_name.php <name>
	require_once "../../bootstrap.php";
	
	$client = new Client();
	$client = setNomComplet("Ngor SECK");
	$client = setEmail("orbitturner@gmail.com");
	
	$entityManager->persist($client);
	$entityManager->flush();
	
	echo "Created Product with ID ".$client->getId() ."\n";
	
	// Queries
	$productsRepos =$entityManager->getRepository('Client');
		$clients = $productsRepos->findAll();
	ou
	$productsRepos =$entityManager->getRepository('Client')
								->findBy(array('nomComplet' => 'Ngor SECK'));
	
	// foreach pour parcourir
	
	// CUSTOM QUERY
	$query = $entityManager->createQuery("SELECT c FROM Client c WHERE c.nomComplet = 'Orbit Turner'");
	$clients = $query->getResult();
	 
	foreach on parcours
	 // UPDATE
	 $client = $entityManager->find('Client',1);
	 if($client!= null){
		$client->setTelephone("+221774339716");
		$entityManager->flush();
	 }else{
		 die("Object n° not found");
	 }
	 
	 // DELETE
	 $client = $entityManager->find('Client',1);
	 if($client!= null){
		$entityManager->remove($client);
		$entityManager->flush();
	 }else{
		 die("Object n° not found");
	 }