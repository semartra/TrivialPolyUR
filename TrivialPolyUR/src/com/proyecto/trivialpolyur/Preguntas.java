package com.proyecto.trivialpolyur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.R.array;
import android.R.string;

public class Preguntas {

	private HashMap<String,HashMap<Integer, String[]>> listaPreguntas=new HashMap<String, HashMap<Integer, String[]>>();
	
	/////////
	
	
	//Declaracion de almacen de preguntas;
	HashMap<Integer, String[]> historia=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> geografia=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> mates=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> enfermeria=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> ingles=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> quimica=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> fisica=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> lenguaje=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> juridico=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> empresa=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> turismo=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> informatica=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> magisterio=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> enologia=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> agricola=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> industrial=new HashMap<Integer, String[]>();
	HashMap<Integer, String[]> experiencia=new HashMap<Integer, String[]>();
	
	public void rellenar(){
	//Historia

		String[] historiaL1={"Cual fue el último monarca de los austrias","Carlos III","FernandoVIII","Carlos II","Alfonso X","Carlos II"};
		historia.put(1, historiaL1);
		String[] historiaL2={"Quien fuel el primer presidente de la democracia en España","Manuel Fraga","Santiago Carrillo","Franco","Adolfo Suarez","Adolfo Suarez"};
		historia.put(2, historiaL2);
		String[] historiaL3={"Como se llama el primer presidente negro de USA","Obama","Lebron James","Usain Bolt","Louis Amstrong","Obama"};
		historia.put(3, historiaL3);
		String[] historiaL4={"En qué año fue la revolución francesa","1798","1879","1789","1897","1789"};
		historia.put(4, historiaL4);
		String[] historiaL5={"En que año termino la reconquista en España","1205","1492","1942","1502","1492"};
		historia.put(5, historiaL5);
		String[] historiaL6={"A qué país se enfrenta España en el desastre de 1898","Estados Unidos","Gran Bretaña", "Francia","Ninguno","Estados Unidos"};
		historia.put(6, historiaL6);
		String[] historiaL7={"En qué año fue la revuelta que derrocó la monarquía en Rusia","1971","1900","1914","1917","1917"};
		historia.put(7, historiaL7);
		String[] historiaL8={"A qué casa reinante pertenece el actual rey de España","Habsburgo","Avis","Anjou","Borbon","Borbon"};
		historia.put(8, historiaL8);
		String[] historiaL9={"En qué isla estuvo Napoleón en su primer destierro","Martinica","Cabo Verde","Elba","Santa Helena","Elba"};
		historia.put(9, historiaL9);
		String[] historiaL10={"Cual fue el último monarca de los austrias","Carlos III","FernandoVIII","Carlos II","Alfonso X","Carlos II"};
		historia.put(10, historiaL10);
		
		
		String[] geografiaL1={"Cual es la capital de los Estados Unidos","Los Angeles","Houston","Washington","Nueva York","Washington"};
		geografia.put(1, geografiaL1);
		String[] geografiaL2={"Cual es el país más grande del mundo","Canadá","Rusia","Estados Unidos","España","Rusia"};
		geografia.put(2, geografiaL2);
		String[] geografiaL3={"Cual de los siguientes paises no esta en el continente americano","Canadá","Honduras","España","México","España"};
		geografia.put(3, geografiaL3);
		String[] geografiaL4={"Cual de los siguientes países, no es un país actual","Líbano","Turquía","Imperio Otomano","Turquía","Imperio Otomano"};
		geografia.put(4, geografiaL4);
		String[] geografiaL5={"Con qué país no linda España","Francia","Portugal","Marruecos","Alemania","Alemania"};
		geografia.put(5, geografiaL5);
		String[] geografiaL6={"Cual es el monte más alto de la península ibérica","Mulhacén","Aneto","San Lorenzo","Teide","Mulhacén"};
		geografia.put(6, geografiaL6);
		String[] geografiaL7={"Cual es el río que pasa por Londres","Ródano","Tajo","Támesis","Rin","Támesis"};
		geografia.put(7, geografiaL7);
		String[] geografiaL8={"Cual es la capital de Japon","Tokio","Kyoto","Osaka","Nagasaki","Japón"};
		geografia.put(8, geografiaL8);
		String[] geografiaL9={"De qué país es capital la Habana","Cuba","Puerto Rico","Bahamas","Jamaica","Cuba"};
		geografia.put(9, geografiaL9);
		String[] geografiaL10={"Cual es la capital de Brasil","Rio de Janeiro","Salvador de Bahía","Brasilia","Pernambuco","Brasilia"};
		geografia.put(10, geografiaL10);
		
		
		String[] matesL1={"Cual es el primer número primo","0","1","2","3","2"};
		mates.put(1, matesL1);
		String[] matesL2={"2 elevado a 0 es","0","2","3","1","1"};
		mates.put(2, matesL2);
		String[] matesL3={"Cual es la raíz de 144","10","12","15","13","12"};
		mates.put(3, matesL3);
		String[] matesL4={"Señala cuál de las siguientes medidas estadísticas no es un parámetro de dispersión","Desviación Típica","Varianza","Mediana","Rango","Mediana"};
		mates.put(4, matesL4);
		String[] matesL5={"En una serie con los días de cada mes del año, ¿cuál es la moda?","7","12","31","30","31"};
		mates.put(5, matesL5);
		String[] matesL7={"Que nombre recibe la parte numérica en un término de una expresión algebraica?","Identidad","Variable","Coeficiente","Parte literal","Coeficiente"};
		mates.put(6, matesL7);
		String[] matesL8={"Al representar en una gráfica diferentes valores de dos magnitudes inversamente proporcionales, ¿Como es la línea que une todos los puntos?","Curva decreciente","Recta creciente","Recta decreciente","Curva decreciente","Curva decreciente"};
		mates.put(7, matesL8);
		String[] matesL9={"Como se llama el punto donde se cortan las medianas de cada lado de un triángulo?","Incentro","Circuncentro","Baricentro","Ortocentro","Baricentro"};
		mates.put(8, matesL9);
		String[] matesL10={"¿Qué valor se obtiene al eliminar el signo de un número entero?","Inverso","Opuesto","Simétrico","Absoluto","Absoluto"};
		mates.put(9, matesL10);
		
		String[] enfermeriaL1={	"¿Cuál de las siguientes es una articulación inmóvil o fija?","Sinartrosis","Artrosis","Diartrosis","Anfiartrosis","Sinartrosis"};
		enfermeria.put(1, enfermeriaL1);
		String[] enfermeriaL2={	"La Hipertrofia Muscular es un ...","Término que indica reducción de la masa muscular","Término que indica gran altura","Término que indica aumento de la masa muscular","Término que indica aumento de tamaño","Término que indica aumento de la masa muscular"};
		enfermeria.put(2, enfermeriaL2);
		String[] enfermeriaL3={	"Se conoce como serie roja de la sangre a:","Leucocitos","Hematíes","Plaquetas","Linfocitos","Hematíes"};
		enfermeria.put(3, enfermeriaL3);
		String[] enfermeriaL4={	"¿Qué células son responsables de la reabsorción del tejido óseo?","Osteoclastos","Osteocitos","Adipocitos","Osteoblastos","Osteoclastos"};
		enfermeria.put(4, enfermeriaL4);		
		String[] enfermeriaL5={"Que graduacion tiene el alcohol que utilizamos para curarnos?","88","96","86","98","96"};
		enfermeria.put(5, enfermeriaL5);
		String[] enfermeriaL6={"Cual es el hueso mas largo del cuerpo humano?","Femur","Antebrazo","Perone","Tibia","Femur"};
		enfermeria.put(6, enfermeriaL6);
		
		String[] inglesL1={	"¿Cual de los siguientes objetos podemos encontrar en una casa?","Table","Car","Sun","Pool","Table"};
		ingles.put(1, inglesL1);
		String[] inglesL2={	"¿En donde dormimos?","Table","Door","Bed","Bad","Bed"};
		ingles.put(2, inglesL2);
		String[] inglesL3={	"¿Con que nos lavamos la cara cada mañana?","Caffe","Watt","Water","Watch","Water"};
		ingles.put(3, inglesL3);
		String[] inglesL4={	"Selecciona la oración que hace un uso correcto del tiempo verbal","Did you readed an amazing adventure novel last summer","I sent you an email yesterday","Did you wrote the shopping list on a yellow paper?","Did you met my brother at the bowling alley","I sent you an email yesterday"};
		ingles.put(4, inglesL4);
		String[] inglesL5={	"Selecciona la oración que hace un uso correcto del tiempo verbal","The scientist did took lots of photos of the birds","You did a teddy bear as child","Did you took lots of photos of the birds","I studied hard for the exam","I studied hard for the exam"};
		ingles.put(5, inglesL5);
		String[] inglesL6={	"Selecciona la oración que hace un uso correcto del tiempo verbal","Did you runed after the bus?","Did you meet my brother at the bowling alley?","The dog did runned after the bus","The teacher didn´t met my brother at the bowling alley","Did you meet my brother at the bowling alley?"};
		ingles.put(6, inglesL6);
		String[] inglesL7={	"Selecciona la oración que hace un uso correcto del tiempo verbal","The dog ran after the bus","Do you sent an email yesterday?","You didn't haved a teddy bear as a child","My brother did wrote the shopping list on a yellow paper","The dog ran after the bus"};
		ingles.put(7, inglesL7);
		String[] inglesL8={	"Selecciona la oración que hace un uso correcto del tiempo verbal","I went to the zoo last week","Did you meeted my brother at the bowling alley?","The student didn´t readed an amazing adventure novel last","The president don´t thought it was a good idea","I went to the zoo last week"};
		ingles.put(8, inglesL8);
		

		String[] quimicaL1={	"Señala cuál de las siguientes características cuantitativas de la tabla periódica es incorrecta","7 períodos","4 bloques","16 grupos","118 elementos","16 grupos"};
		quimica.put(1, quimicaL1);
		String[] quimicaL2={	"¿En qué lugar de la tabla periódica se encuentran los elementos con mayor electronegatividad?","Arriba a la derecha","Abajo a la derecha","Abajo a la izquierda","Arriba a la izquierda","Arriba a la derecha"};
		quimica.put(2, quimicaL2);
		String[] quimicaL3={	"Cual es la propiedad periódica más importante de los elementos químicos","Número de protones","Configuración electrónica","Volumen atómico","Masa atómica","Configuración electrónica"};
		quimica.put(3, quimicaL3);
		String[] quimicaL4={	"De las siguientes afirmaciones sobre los elementos metálicos hay una incorrecta. ¿Cual?","Muchos electrones de valencia","Tienen baja afinidad electrónica","Ceden fácilmente electrones","Están en zonas bajas de energía de ionización","Muchos electrones de valencia"};
		quimica.put(4, quimicaL4);
		String[] quimicaL5={	"Que es H2SO4","ácido nitroso","ácido sulfúrico","ácido sulforoso","ácido nítrico","ácido sulfúrico"};
		quimica.put(5, quimicaL5);
		String[] quimicaL6={	"¿Qué afirma el principio de mínima energía que afecta a la estructura electrónico de los átomos?","Los electrones orbitan a la menor velocidad que les permite no caer sobre el núcleo","Los electrones ocupan primero los niveles de menor energía","Los electrones se trasladan a órbitas distintas de menor gasto de energía","La energía centrípeta de los electrones se anula con la fuerza de atracción de los neutrones","Los electrones ocupan primero los niveles de menor energía"};
		quimica.put(6, quimicaL6);
		String[] quimicaL7={	"¿En qué consiste el el efecto pantalla?","La no reactividad de los gases nobles al tener lleno su último nivel de energía","La atracción de átomos del mismo grupo periódico","Los electrones de las capas externas giran a mayor velocidad que los de las internas","La repulsión entre electrones de distintos niveles","La repulsión entre electrones de distintos niveles"};
		quimica.put(7, quimicaL7);
		String[] quimicaL8={	"Ordena de izquierda a derecha de la tabla periódica los siguientes grupos","Alcalinos, Térreos, Anfígenos","Alcalinos, Anfígenos, Térreos","Térreos, Anfígenos, Alcalinos","Anfígenos, Alcalinos, Térreos","Alcalinos, Térreos, Anfígenos"};
		quimica.put(8, quimicaL8);
		
		String[] fisicaL1={	"Junto a la carga eléctrica, ¿que otra variable entra en juego para explicar el flujo eléctrico?","Superficie","Permitividad","Tiempo","Velocidad","Superficie"};
		fisica.put(1, fisicaL1);
		String[] fisicaL2={	"Qué dispositivo que permite almacenar energía esta formado por dos placas conductoras paralelas entre sí que poseen cargas opuestas con el mismo módulo","Diferenciador","Condensador","Transformador","Conmutador","Condensador"};
		fisica.put(2, fisicaL2);
		String[] fisicaL3={	"Cual es la propiedad periódica más importante de los elementos químicos","Número de protones","Configuración electrónica","Volumen atómico","Masa atómica","Configuración electrónica"};
		fisica.put(3, fisicaL3);
		String[] fisicaL4={	"Cual es la constante dieléctrica del vacío","8.85*10^-12","0","1","1/4PI","8.85*10^-12"};
		fisica.put(4, fisicaL4);
		String[] fisicaL5={		"Que nombre recibe la propiedad de un material para interponerse entre las cargas de un campo eléctrico","Conductividad","Remanencia","Susceptibilidad Dieléctrica","Permitividad","Permitividad"};
		fisica.put(5, fisicaL5);
		String[] fisicaL6={	"Cual es la unidad de carga según el sistema internacional de Unidades","Culombio","Electrón","Amperio","Voltio","Culombio"};
		fisica.put(6, fisicaL6);
		String[] fisicaL7={	"¿Que trabajo hay que realizar para mover una carga de un culombio entre dos puntos situados ambos a un metro de un manantial?","10J","0.1J","0J","1J","0J"};
		fisica.put(7, fisicaL7);
		String[] fisicaL8={	"Las cargas eléctricas, tanto positivas como negativas, ejercen una influencia de atraccion o repulsion en el espacio que les rodea.¿Qué nombre recibe este espacio?","Potencial eléctrico","Densidad de carga","Espacio de Coulomb","Campo eléctrico","Campo eléctrico"};
		fisica.put(8, fisicaL8);
		String[] fisicaL9={"Indica la afirmación falsa sobre el potencial eléctrico","Los puntos equidistantes del manantial tienen igual potencial","Es una magnitud escalar","Se calcula mediante la fórmula W/q","Su unidad de medida es el culombio","Su unidad de medida es el culombio"};
		fisica.put(9, fisicaL9);

		String[] lenguajeL1={"Durante qué época se produce en España la transformación consonántica del castellano","Siglo XIX","Ilustracion","Siglo de Oro","Edad Media","Siglo de Oro"};
		lenguaje.put(1, lenguajeL1);
		String[] lenguajeL2={"El español en Filipinas es usado por una minoría, sobre todo desde que perdió su carácter de cooficial en 1992, a favor del inglés y de la lengua vernácula del lugar. ¿Cuál?","Tagalo","Chamico","Yami","Malayo","Tagalo"};
		lenguaje.put(2, lenguajeL2);
		String[] lenguajeL3={"El euskera, al contrario del resto de idiomas del territorio español, es una lengua aglutinante. ¿Qué significa?","Tiene mayor presencia de grupos consonánticos","Unen varias palabras en una sola","No tiene conjugación verbal","Su léxico está formado por palabras de distintas lenguas","Unen varias palabras en una sola"};
		lenguaje.put(3, lenguajeL3);
		String[] lenguajeL4={"En qué único país africano el castellano es lengua cooficial, debido a la presencia española en la zona desde hace siglos","Marruecos","Gabón","Argelia","Guinea Ecuatorial","Guinea Ecuatorial"};
		lenguaje.put(4, lenguajeL4);
		String[] lenguajeL5={"Señala cuál de las siguientes afirmaciones sobre el vascuence no es correcta","Su origen es incierto","Tiene varios dialectos","Desde sus orígenes ha existido un modelo normativo de uso","Se habla en dos comunidades autónomas en España","Desde sus orígenes ha existido un modelo normativo de uso"};
		lenguaje.put(5, lenguajeL5);
		String[] lenguajeL6={"Indica cuál de los siguientes sistemas de comunicación es un dialecto del castellano","Gallego","Euskera","Andaluz","Catalán","Andaluz"};
		lenguaje.put(6, lenguajeL6);
		String[] lenguajeL7={"¿En qué consiste el recurso literario de la metonimia?","En sustituir una palabra por otra relacionada por proximidad","En afirmar una exageración","En cambiar el orden gramatical de las palabras","En decir algo contradictorio","En sustituir una palabra por otra relacionada por proximidad"};
		lenguaje.put(7, lenguajeL7);
		String[] lenguajeL8={"Desde un punto de vista semántico, ¿qué le pasa una palabra de uso común cuando se convierte en tecnicismo?","Gana en precisión","Se considera polisémica","Aumenta su extensión semántica","Reduce su precisión","Gana en precisión"};
		lenguaje.put(8, lenguajeL8);
		String[] lenguajeL9={"¿Como se denomina al uso de una misma palabra con doble?","Polisemia","Diología","Paronimía","Homonimia","Diología"};
		lenguaje.put(9, lenguajeL9);

		String[] juridicoL1={"Que rama del derecho Público interno regula los delitos?","Derecho Laboral","Derecho Civil","Derecho Penal","Ningún Derecho","Derecho Penal"};
		juridico.put(1, juridicoL1);
		String[] juridicoL2={"Acuerdo entre 2 o mas personas que regula derechos y obligaciones?","Contrato","Matrimonial","Obligación","Ninguno de los tres","Contrato"};
		juridico.put(2, juridicoL2);
		String[] juridicoL3={"Es el vínculo jurídico entre dos o más personas, en virtud del cual una de ellas puede exigir a otra una prestación a una abstención","Contrato","Obligación","Matrimonio","Ninguna de las tres","Obligación"};
		juridico.put(3, juridicoL3);
		String[] juridicoL4={"Como se llama al castigo impuesto por un juez penal al infractor?","Estupro","Pena","Obligación","Contrato","Pena"};
		juridico.put(4, juridicoL4);
		String[] juridicoL5={"Derecho que establece las relaciones privadas entre las personas?","Derecho civil","Derecho Administrativo","Derecho laboral","Derecho penal","Derecho civil"};
		juridico.put(5, juridicoL5);

		String[] empresaL1={	"¿Qué es el IVA?","Impuesto Valor Asociado","Impuesto Valor Añadido","Impuesto Variable Añadido","Impuesto Validación Asociado","Impuesto Valor Añadido"};
		empresa.put(1, empresaL1);
		String[] empresaL2={	"¿Qué es el IRPF?","Impuesto de la renta de la personas físicas","Impuesto retributivo de personalidades Físicas","Impuesto racionalizado de personas físicas","Impuesto sobre la renta de las personas físicas","Impuesto sobre la renta de las personas físicas"};
		empresa.put(2, empresaL2);
		String[] empresaL3={	"El concepto de amortización en los bienes de activo no corriente significa","Depreciación sistemática e irreversible","Depreciación no sistemática y reversible","Depreciación sistemática y reversible","Depreciación no sistemática e irreversible","Depreciación sistemática e irreversible"};
		empresa.put(3, empresaL3);
		String[] empresaL4={	"Que principio contable tiene carácter preferencial sobre los demás principios","Principio de prudencia","Principio del devengo","Principio de empresa en funcionamiento","Ninguna de las anteriores",""};
		empresa.put(4, empresaL4);
		String[] empresaL5={	"Qué criterio se utiliza para evaluar si un bien inmovilizado se ha deteriorado es el","Valor en uso","Valor residual","Valor contable","Ninguna de las anteriores","Valor en uso"};
		empresa.put(5, empresaL5);
		String[] empresaL6={	"Entre los criterios de valoración que se establecen en el PGC, No se encuentra el:","Coste amortización","Valor neto realizable","Coste de oportunidad","Ninguna de las anteriores","Coste de oportunidad"};
		empresa.put(6, empresaL6);
		String[] empresaL7={	"El criterio del valor actual se aplica a","Activos y pasivos","Existencias","Acciones","Todas las anteriores","Activos y pasivos"};
		empresa.put(7, empresaL7);
		String[] empresaL8={	"Para evaluar el deterioro de las existencias, se utiliza el criterio del:","Valor neto realizable","Valor actual","Valor en uso","Ninguna de las anteriores","Valor neto realizable"};
		empresa.put(8, empresaL8);
		String[] empresaL9={	"El criterio de coste de producción se aplica a:","Inversiones financieras","Activos fabricados por la propia empresa","Pasivos que surgen de las operaciones con terceros","Todas las anteriores","Activos fabricados por la propia empresa"};
		empresa.put(9, empresaL9);
		
		String[] turismoL1={	"Una rama del derecho Público interno se encarga de regular los delitos, las penas y medidas de seguridad","Derecho Laboral","Derecho Civil","Derecho Penal","Ningún Derecho","Derecho Penal"};
		turismo.put(1, turismoL1);
		String[] turismoL2={	"Cual es el monte más alto de la península ibérica","Mulhacén","Aneto","San Lorenzo","Teide","Mulhacén"};
		turismo.put(2, turismoL2);
		String[] turismoL3={	"Selecciona la oración que hace un uso correcto del tiempo verbal","Did you readed an amazing adventure novel last summer","I sent you an email yesterday","Did you wrote the shopping list on a yellow paper?","Did you met my brother at the bowling alley","I sent you an email yesterday"};
		turismo.put(3, turismoL3);
		String[] turismoL4={	"Selecciona la oración que hace un uso correcto del tiempo verbal","The scientist did took lots of photos of the birds","You did a teddy bear as child","Did you took lots of photos of the birds","I studied hard for the exam","I studied hard for the exam"};
		turismo.put(4, turismoL4);
		String[] turismoL5={	"Cual de estos ríos no desemboca en España","Tajo","Guadalquivir","Turia","Ebro","Tajo"};
		turismo.put(5, turismoL5);
		String[] turismoL6={	"Selecciona la oración que hace un uso correcto del tiempo verbal","Did you runed after the bus?","Did you meet my brother at the bowling alley?","The dog did runned after the bus","The teacher didn´t met my brother at the bowling alley","Did you meet my brother at the bowling alley?"};
		turismo.put(6, turismoL6);
		String[] turismoL7={	"Cuantas provincias tiene la comunidad autónoma de Madrid","2","3","1","6","1"};
		turismo.put(7, turismoL7);
		
		String[] informaticaL1={	"Cuanta RAM se utilizará como máximo en un sistema de 32 bits","4","8","32","16","4"};
		informatica.put(1, informaticaL1);
		String[] informaticaL2={	"Que tipo de lenguaje no es de alto nivel","Fortran","Cobol","Basic","Ensamblador","Ensamblador"};
		informatica.put(2, informaticaL2);
		String[] informaticaL3={	"Que sistema operativo desaparece en 2014","XP","Vista","Windows 7","Windows 8","XP"};
		informatica.put(3, informaticaL3);
		String[] informaticaL4={	"Segun las estadisticas que SO está más expandido","Android","Windows Phone","BlackBerry","IOS","Android"};
		informatica.put(4, informaticaL4);
		String[] informaticaL5={	"Que elemento se encarga de almacenar los programas en ejecución","RAM","Disco Duro","Memoria USB","Procesador","RAM"};
		informatica.put(5, informaticaL5);
		String[] informaticaL6={	"Que lenguaje no es utilizado en programación web","PHP","JavaScript","HTML","Ensamblador","Ensamblador"};
		informatica.put(6, informaticaL6);
		String[] informaticaL7={	"Que registro no es de propósito general","AX","SI","DX","CX","SI"};
		informatica.put(7, informaticaL7);
		String[] informaticaL8={	"La sigla TB es","TimoByte","TodoByte","TeraByte","TacoByte","TeraByte"};
		informatica.put(8, informaticaL8);
		String[] informaticaL9={	"Cual es el sistema numérico basado en 0 y 1","decimal","hexadecimal","binario","octal","binario"};
		informatica.put(9, informaticaL9);
		
		String[] magisterioL1={"Cuántos animales de cada especie metió Moisés en el Arca","Ninguno","10","100","1000","Ninguno"};
		magisterio.put(1, magisterioL1);
		String[] magisterioL2={"Qué es lo primero que hace el sol cuando sale","Iluminar","Amanecer","Sombra","Brillar","Sombra"};
		magisterio.put(2, magisterioL2);
		String[] magisterioL3={"Cuales son las cuatro letras que hacen a una niña mujer","Adolencia","Edad","Madurez","Ninguna","Edad"};
		magisterio.put(3, magisterioL3);
		String[] magisterioL4={"Qué es aquello que cuanto más hay menos se ve","Oscuridad","Sol","Tierra","Mar","Oscuridad"};
		magisterio.put(4, magisterioL4);
		String[] magisterioL5={"Qué es aquello que cuando mas roto esta menos agujeros tiene","Red","Colador","Surcido","Ninguno","Red"};
		magisterio.put(5, magisterioL5);
		String[] magisterioL6={"Quien puede hablar todas las lenguas","Trilingües","Bilingües","Eco","Ninguno","Eco"};
		magisterio.put(6, magisterioL6);
		String[] magisterioL7={"Cual era la montaña más alta antes de que se descubriera el Everest","Tungurahua","Chimborazo","Everest","K2","Everest"};
		magisterio.put(7, magisterioL7);
		String[] magisterioL8={"Donde se registra el mayor índice de robos?","Barcos","Aviones","Buses","Trenes","Barcos"};
		magisterio.put(8, magisterioL8);
		String[] magisterioL9={"Cuando se puede llevar agua en un colador","Cuando está purificada","Cuando está contaminada","Cuando está helada","Cuando está evaporada","Cuando está helada"};
		magisterio.put(9, magisterioL9);
		String[] magisterioL10={"Qué es lo que se pone sobre la mesa, se corta y no se come","Arroz","Plato","Baraja","Mantel","Baraja"};
		magisterio.put(10, magisterioL10);
		String[] magisterioL11={"Cuánto tiempo hace falta para cocer un huevo duro","15 minutos","Nada","30 minutos","10 minutos","Nada"};
		magisterio.put(11, magisterioL11);
		String[] magisterioL12={"Que hay entre la espada y la pared","y","a","l","p","y"};
		magisterio.put(12, magisterioL12);
		String[] magisterioL13={"Cual es el parentesco más cercano que puede tener contigo la cuñada de la hermana de tus padres","Nada","Prima","Tía","Madre","Madre"};
		magisterio.put(13, magisterioL13);
		String[] magisterioL14={"Cuando se puede llevar agua en un colador","Cuando está purificada","Cuando está contaminada","Cuando está helada","Cuando está evaporada","Cuando está helada"};
		magisterio.put(14, magisterioL14);
		String[] magisterioL15={"Quien mato a Cain","Marcos","Abel","Mateo","Nadie","Abel"};
		magisterio.put(15, magisterioL15);
		String[] magisterioL16={"Cual es el número que al revés vale menos","3","Ninguno","8","9","9"};
		magisterio.put(16, magisterioL16);
		String[] magisterioL17={"Qué tiene Adán delante que Eva tiene atras?","E","N","A","V","A"};
		magisterio.put(17, magisterioL17);
		String[] magisterioL18={"Cuantos meses tienen 28 días","2","1","Todos","3","Todos"};
		magisterio.put(18, magisterioL18);
		
		String[] enologiaL1={"La vendimia mecánica de uva sana, está contraindicada para la elaboración  de:","Vinos tintos por el sistema tradicional","Vinos tintos por termovinificacion","Vinos tintos por maceración carbónica","Ninguna","Vinos tintos por maceración carbónica"};
		enologia.put(1, enologiaL1);
		String[] enologiaL2={"El procedimiento más fiable para determinar el estado sanitario de la vendimia es","Textura de la uva","Contenido en laccasa","Contenido de azúcares","Ninguna","Contenido en laccasa"};
		enologia.put(2, enologiaL2);
		String[] enologiaL3={"Uno de los mayores inconvenientes de los sistemas estáticos de escurrido de mostos es","Obtencion de mostos muy turbios","Obtención de mostos muy oxidados","Obtención de mostos poco aromáticos","Ninguna","Obtención de mostos muy oxidados"};
		enologia.put(3, enologiaL3);
		String[] enologiaL4={"El principal inconveniente que presentan los escurridores dinámicos de tornillo sin fin, es","Mostos muy turbios","Mostos muy oxidados","Poco volumen de mosto","Ninguna","Mostos muy turbios"};
		enologia.put(4, enologiaL4);
		String[] enologiaL5={"La presencia de raspon en la fase de prensado de una vinificación en blancos, sirve para","Extraer mayor calidad de sustancias aromáticas","Obtener mostos más pálidos","Facilitar el drenaje del mosto","Ninguna","Facilitar el drenaje del mosto"};
		enologia.put(5, enologiaL5);
		String[] enologiaL6={"La adición de enzimas pectoliticas a un mosto de uva blanca, durante el desfangado, sirve","Para eliminar compuestos polifenolicos","Acortar tiempo de desfangado","Obtener mostos mas ricos en pectinas","Ninguna","Acortar tiempo de desfangado"};
		enologia.put(6, enologiaL6);
		String[] enologiaL7={"La criomaceración es una técnica de vinificación que la industria enológica utiliza para","Elaborar tintos jóvenes","Elaborar rosados de calidad","Elaborar blancos jóvenes","Ninguna","Elaborar blancos jóvenes"};
		enologia.put(7, enologiaL7);
		String[] enologiaL8={"La finalidad de la criomaceración es","Conseguir vinos con más extracto","Conseguir vinos con un color más intenso","Conseguir vinos más aromáticos","Ninguna","Conseguir vinos más aromáticos"};
		enologia.put(8, enologiaL8);
		String[] enologiaL9={"En una vinificación de tintos por el sistema tradicional, el primer remontado, debe hacerse","Sin aireación","Con aireación","Mixto","Ninguna","Con aireación"};
		enologia.put(9, enologiaL9);
		
		
		String[] agricolaL1={"El laboreo cuando se ejecuta a una profundidad de 25cm se considera","Laboreo profundo","Laboreo medio","Laboreo superficial","Laboreo somero","Laboreo medio"};
		agricola.put(1, agricolaL1);
		String[] agricolaL2={"De las siguientes unidades en tuberías de riego, cual es de tipo flexible?","Gibault","Por manguitos","Singer","Por platinas","Gibault" };
		agricola.put(2, agricolaL2);
		String[] agricolaL3={"El repilo es","Una plaga","Un virus","Un hongo","Un insecto","Un hongo" };
		agricola.put(3, agricolaL3);
		String[] agricolaL4={"En el cultivo cuál es el periodo de mayor actividad fisiológica","Encañado","Ahijamiento","Espigado","Maduración","Espigado" };
		agricola.put(4, agricolaL4);
		String[] agricolaL5={"El prunus persica es el","Peral","Melocotonero","Ciruelo","Cerezo","Melocotonero" };
		agricola.put(5, agricolaL5);
		String[] agricolaL6={"Las variedades de melocotonero de pulpa dura o semidura adherida al hueso, se denominan","De pulpa blanca","De pulpa amarilla","Tipo pavia","Tipo Alexandra","Tipo pavia" };
		agricola.put(6, agricolaL6);
		String[] agricolaL7={"La primera especie del género Prunus que florece en primavera es el","Ciruelo","Almendro","Peral","Higuera","Almendro" };
		agricola.put(7, agricolaL7);
		String[] agricolaL8={"Indica cual de las siguientes es una hortaliza resistente al frío","Pepino","Calabaza","Berenjena","Col","Col"};
		agricola.put(8, agricolaL8);
		String[] agricolaL9={"Que raza ovina posee el mayor índice de prolificidad","Talaverana","Merino","Manchega","Lacha","Manchega" };
		agricola.put(9, agricolaL9);
			
		String[] industrialL1={"A quien se le considera el 'padre' de los Autómatas programables","Von Braun","Turing","R.E.Moreley Universidad de California","Ninguna de las anteriores","R.E.Moreley Universidad de California" };
		industrial.put(1, industrialL1);
		String[] industrialL2={"Como se llamaba primer Autómata Programable que se comercializó","MODICON 080","MODICON 084","MODICON 087","MODICON 085","MODICON 084" };
		industrial.put(2, industrialL2);
		String[] industrialL3={"Cuales son los fabricantes de Autómatas mas importantes.","Allen Bradley, Siemens, Ford, Schenneider","General Motors, Siemens, Omron, Schenneider","Allen Bradley, Siemens, IBM, Schenneider","Allen Bradley, Siemens, Omron, Schenneider","Allen Bradley, Siemens, Omron, Schenneider"};
		industrial.put(3, industrialL3);	
		String[] industrialL4={"Cual es el lenguaje de programación fundamental de los PLC?","Booleanos","Instrucciones","Contactos","Algebraicos","Contactos"};
		industrial.put(4, industrialL4);
		String[] industrialL5={"Norma que estandariza los lenguajes de programación de los PLC?","IEC1130-3","IEC1131-3","IEC1132-3","Ninguna de las anteriores","IEC1131-3"};
		industrial.put(5, industrialL5);
		String[] industrialL6={"Que es un PLC?","Controlador Logico Programable","Controlador Lineal Programable","Concentrador Logico Programable","","Controlador Logico Pirolitico"};
		industrial.put(6, industrialL6);
		String[] industrialL7={"En que se mide la frecuencia?","Deciberios (dB)","Hercios (Hz)","Mbps","Ninguna es correcta","Hercios (Hz)"};
		industrial.put(7, industrialL7);
		String[] industrialL8={"Que valor posible para los bits de trama no es correcto?","4","5","6","7","4"};
		industrial.put(8, industrialL8);			
		
		String[] experienciaL1={"Cuantos perlos tiene Homer Simpson en la cabeza","0","1","2","3","3"};
		experiencia.put(1, experienciaL1);
		String[] experienciaL2={"En que año gano España el mundial de Sudafrica","2008","2010","2012","2014","2010"};
		experiencia.put(2, experienciaL2);
		String[] experienciaL3={"Que pesa mas 1kg de paja o de hierro","La paja","El hierro","Igual","El hierro pesa 2 veces mas","Igual"};
		experiencia.put(3, experienciaL3);
		String[] experienciaL4={"De cuantos años consta una carrera un Bolonia","4","5","6","7","4"};
		experiencia.put(4, experienciaL4);
		String[] experienciaL5={"Cual es limite de velocidad en autopistas","80","90","110","120","120"};
		experiencia.put(5, experienciaL5);
		String[] experienciaL6={"Que animal tropieza 2 veces en la misma piedra?","perro","hombre","burro","gato","hombre"};
		experiencia.put(6, experienciaL6);
		String[] experienciaL7={"Cuantas autonomias tiene España?","5","10","17","23","17"};
		experiencia.put(7, experienciaL7);
		
		listaPreguntas.put("agricola", agricola);
		listaPreguntas.put("enologia", enologia);
		listaPreguntas.put("enfermeria", enfermeria);
		listaPreguntas.put("empresa", empresa);
		listaPreguntas.put("mates", mates);
		listaPreguntas.put("magisterio", magisterio);
		listaPreguntas.put("informatica", informatica);
		listaPreguntas.put("ingles", ingles);
		listaPreguntas.put("turismo", turismo);
		listaPreguntas.put("juridico", juridico);
		listaPreguntas.put("lenguaje", lenguaje);
		listaPreguntas.put("fisica", fisica);
		listaPreguntas.put("quimica", quimica);
		listaPreguntas.put("geografia", geografia);
		listaPreguntas.put("historia", historia);
		listaPreguntas.put("industrial", industrial);
		listaPreguntas.put("experiencia", experiencia);

	}
	
	public Preguntas(){
		this.rellenar();
	}
	
	public String[] getPregunta(String categoria){
		HashMap<Integer, String[]> listaP = this.listaPreguntas.get(categoria);
		int total=listaP.size();
		
		int numero_alea = (int) (Math.random()*total+1);
		
		return listaP.get(numero_alea);
	}
	
}