-- MySQL dump 10.13  Distrib 5.5.32, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: shiva
-- ------------------------------------------------------
-- Server version	5.5.32-0ubuntu0.12.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `oldernewsdetails`
--

DROP TABLE IF EXISTS `oldernewsdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oldernewsdetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10000) CHARACTER SET utf8 NOT NULL,
  `details` varchar(10000) CHARACTER SET utf8 NOT NULL,
  `lastupdated` varchar(11) CHARACTER SET utf8 NOT NULL,
  `authflag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `personid` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oldernewsdetails`
--

LOCK TABLES `oldernewsdetails` WRITE;
/*!40000 ALTER TABLE `oldernewsdetails` DISABLE KEYS */;
INSERT INTO `oldernewsdetails` VALUES (1,'महात्मा बसवश्वेर अभिवादन','महात्मा बसवश्वेर अभिवादन','2015/05/03','y','2'),(2,'विरशैव लिंगायत समाज  बैठक','जिल्हा  विराशैव लिंगायत समाज उघा बैठक10रोजी सायंकाळी ६.०० वाजता शिव मंदीर मठांमधे महात्मा  बसवश्वेर महाराज यांची मंगळ वार २१ /४/२०१५ नाशिक शिवा संघटना  मेळावात भाग घेणासाठी बैठक  आयोजित करण्यात  आली','2015/05/03','y','2'),(3,'विरशैव लिंगायत समाज  बैठक','जिल्हा  विराशैव लिंगायत समाज उघा बैठक10रोजी सायंकाळी ६.०० वाजता शिव मंदीर मठांमधे महात्मा  बसवश्वेर महाराज यांची मंगळ वार २१ /४/२०१५ नाशिक शिवा संघटना  मेळावात भाग घेणासाठी बैठक  आयोजित करण्यात  आली','2015/05/03','y','2'),(4,'श्रम राज्य ','महात्मा बसवश्वेर जंयती निमित्त  उघा कार्यक्रम \nविरशैव लिंगायत समाज  तफँ बसवश्वेर जंयती उत्सव उघा २१/४/२०१५ साजरा करण्यात येणार आहे या निमित्त उघा बसवश्वेर चौक येथून मोटर सायकल  रँली काढण्यात येईल  सकाळी 10.०० वाजता जिल्हाआधिकिरी कार्यालायात शासकीय पुजन आणि सायंकाळी  ७ वाजता बसवश्वेर चौकतून मिरवणूक  निघणार  आहे जन्म  उत्सव दुपारी १२.०० वाजता महादेव मठ रथगली धुळे येथे होणार आहे तरी सहाभाग आवाहन समस्त धुळे जिल्हा  विरशैव लिंगायत समाज  आणि  शिवा संघटना  वतीने करण्यात आले आहे','2015/05/03','y','2'),(5,'श्रम राज','महात्मा बसवश्वेर जंयती निमित्त  उघा धुळयात विविध कार्यक्रम \n\nविरशैव लिंगायत समाज  धुळे तफँ श्री  महात्मा बसव श्वेर जंयती उत्सव उघा दि. २१/४/२०१५रोजी साजरा करण्यात  येणार  आहे या निमित्त उघा सकाळी ८.०० वाजता बसवश्वेरचौक येथुन मोमोटरसायकल  रँली काढण्यात येईलसकाळी १०.०० वाजता जिल्हाआधिकारी कार्य लयातशासकीय प्रतिमा पुजन आणि  सायंकाळी ७.०० वाजता  बसव श्वेर चौक येथून मिरवणुक निघणार आहे तरी जन्म  उत्सव दुपारी १२.००वाजता महादेव मंदीर मठ रथगली धुळे येथे होणार आहे सहभाग आवाहन समस्त धुळे शिवा संघटना धुळे वतीने विरशैव लिंगायत समाज धुळे यांच्या वतीने करण्यात आले आहे','2015/05/03','y','2'),(6,'खानदेश मैदान  दि.२३/४/२०१५ ','महात्माा   बसवश्वेर जंयतीदिनी अभिवादन\n\nशहरात  महात्मा बसव श्वेर जंयती निमित्त  बसवश्वेर चौकात प्रतिमा अभिवादन सोहळा नुकताच पार पडला वीरशैव लिंगायत समाजाचे आराधय दैवत महात्मा बसवश्वेर यांची जंयती साजरी  करण्यात आली त्या वेळी शिवसेने चे \nसंपर्क प्रमुख मिलँकर साहेब  धुळे जिल्हा प्रमूख हिलाला आणा माळी महानगर प्रमुख  सतीश महाले धिरज पाटील नंदकिशोर लदे किशोर आपा मोगलाईकर कपिल लिंगायत मनोज आंवळकठे हेमंत लिंगाडे गोकूळ लिंगायत तुषार लदे हषँल हेडे पराग लिंगायत योगेश कानडे हेमंत गिरवलकर शिवा संघटना धुळे जिल्हा कार्य कतँ उपस्थित  होते','2015/05/04','y','2'),(7,'खानदेश मैदान       दिनांक १८/४/२०१५','अखिल भारतीय  शिवा संघटनेचा मेळावा नाशिक येथे उत्साहात पार पडलेल्या ह्या  मेळावाचे अध्यक्ष स्थान मनोहर धोडेसर यांनी भूषविले ते शिवा संघटनेचे संस्था पक अध्यक्षआहेत लिंगायत समाजाच्या विविध समस्या  तसेच जाती -पोटजातीना आरक्षण मिळण्यातील अङचणी व त्यावरचे पयाँय मेळावात सूचविण्यात आले धुळे जिल्हा तून व इतर ठिकाणाहून असंख्य  समाज बांधव मेळावात हजर राहिले धुळे जिल्हा तून यांच्या  मागँदशँन खाली अरूण लदे नंदकिशोर लदे किशोर आपा मोगलाईकर पंङित जमदाडे अशोक आंवळकठे हेमंत लिंगाडे गोकूळ लिंगायत वालमीक लिंगायत तुषार लदे राजेश चांदणे साचिन कणँ अमोल (बाळू)कणँ पराग लिंगायत ज्ञानेश्वर  घोगडे गणेश हेडे शिवलिंग वाफेकर विजय नंदाणे संजय कासोदकर हषँल हेडे आदीनी सहृभाग नोंदविला धोडे सर यांनी नं दकीशोर लदे यांचा सत्कार केला','2015/05/04','y','2'),(8,'खानदेश मैदान       दिनांक १८/४/२०१५','अखिल भारतीय  शिवा संघटनेचा मेळावा नाशिक येथे उत्साहात पार पडलेल्या ह्या  मेळावाचे अध्यक्ष स्थान मनोहर धोडेसर यांनी भूषविले ते शिवा संघटनेचे संस्था पक अध्यक्षआहेत लिंगायत समाजाच्या विविध समस्या  तसेच जाती -पोटजातीना आरक्षण मिळण्यातील अङचणी व त्यावरचे पयाँय मेळावात सूचविण्यात आले धुळे जिल्हा तून व इतर ठिकाणाहून असंख्य  समाज बांधव मेळावात हजर राहिले धुळे जिल्हा तून यांच्या  मागँदशँन खाली अरूण लदे नंदकिशोर लदे किशोर आपा मोगलाईकर पंङित जमदाडे अशोक आंवळकठे हेमंत लिंगाडे गोकूळ लिंगायत वालमीक लिंगायत तुषार लदे राजेश चांदणे साचिन कणँ अमोल (बाळू)कणँ पराग लिंगायत ज्ञानेश्वर  घोगडे गणेश हेडे शिवलिंग वाफेकर विजय नंदाणे संजय कासोदकर हषँल हेडे आदीनी सहृभाग नोंदविला धोडे सर यांनी नं दकीशोर लदे यांचा सत्कार केला','2015/05/04','y','2'),(9,'आयआयटी प्रवेशासाठी अत्यंत महत्वाची समजली जाणारी जेईई या परीक्षेत बुलढाणा जिल्ह्याच्या अत्यंत ग्रामीण भागात राहणारा आणि सामान्य परिवारातून आलेल्या आशिष गवई याने देशात सर्वप्रथम ','मे : आयआयटी प्रवेशासाठी अत्यंत महत्वाची समजली जाणारी जेईई या परीक्षेत बुलढाणा जिल्ह्याच्या अत्यंत ग्रामीण भागात राहणारा आणि सामान्य परिवारातून आलेल्या आशिष गवई याने देशात सर्वप्रथम येण्याचा मान मिळवून सर्वांना आश्चर्याचा धक्का दिलाय. अत्यंत प्रतिकूल परिस्थितीत आशिषने संपूर्ण शिक्षण जिल्हा परिषद शाळेत झालं. त्याच्या भरारीमुळे तो ग्रामीण भागातील तरुणांसाठी ब्रँड आयकॉन ठरलाय. त्याच्या या यशाबद्दल दिल्लीचे मुख्यमंत्री अरविंद केजरीवाल, देवयानी खोब्रागडे यांनी विशेष अभिनंदन केले आहे\n\nज्याने तीन वर्षांत कधीही टिव्ही पाहिला नाही ज्याला व्हॉटस्‌ऍप अन् फेसबुक चा अजिबात गंध नाही. त्याला माहित आहेत त्याच्या अभ्यासाचे जाड जाड पुस्तकं अन् संदर्भ ग्रंथ…अन् पुस्तकांचा साज वाचनालयच ज्याचे जीवन असा तो आशिष गवई…वडिल जिल्हा परिषद शाळेवर प्राथमिक शिक्षक त्यामुळे बालपण साखरखेडा या ग्रामीण परिसरात आणि शिक्षण जिल्हा परिषद शाळेत झालं. पुढे अकरावीत विज्ञानमध्ये शाहूमध्ये पूर्ण झालं.\n\nआशिषच्या यशाची भरारी दोन वर्षांपूर्वीपासून सुरूच आहे. के व्ही पी वाय 2013 स्पर्धेत तो भारतातून तिसरा आला. तसंच पुष्पेंदू कुमार दास यांनी त्याला ज्युनियर वैद्न्यानिक पदासाठी 89,300 प्रती महा रुपयाचे पॅकेज ऑफर केले आहे. 2014 महिन्यात रिजनल गणिताच्या ऑलिपियाड स्पर्धेत तो भारतातून पहिला येण्याचा मान ही त्याने पटकाविला होता. अत्यंत मानाचा मानला जाणारा ब्राम्होत्स या अमेरिका सरकारच्या स्पर्धेत पाच लेव्हलपर्यंत क्वालिफाय झाल्याने त्याला न्यूयार्क येथील युक्रोन येथील एआयटीसाठी तेथील कॉलेजसाठी\nनिवडही झाली आहे. तो त्या कॉलेजमध्ये देखील कधिही जावू शकतो.\n\nदिवस रात्र केवळ अभ्यास अन् अभ्यास…केवळ तीन तास झोप आणि अभ्यासात पूर्ण पणे स्वतःला झोकून दिलेला आशिष समोर ज्युनिय साइण्टिस्टचे भरपूर पॅकेज आणि न्युयॉर्कच्या कॉलेजची अशा अनेक ऑफर आहेत. पण त्याला आयआयटीमध्ये करिअर करायचे आहे त्यासाठी त्याने मेकॉनिकलमध्ये प्रवेश घ्यावा असा सल्ला दिल्लीचे मुख्यमंत्री अरविंद केजरीवाल यांनी प्रत्यक्ष फोन करून दिला. आशिषला कॉम्प्युटरमध्ये आयआयटीला प्रवेश घ्यायचा आहे. त्यानंतर त्याला आयएएस होवून मोठा अधिकारी व्हायाचे आहे. त्याच्या आईचे देखिल हेच स्वप्न आहे आपला मुलगा कलेक्टर बनावा.\n\nखेड्या सारख्या ग्रामीण भागात शिकलेला आशिष ज्याने देश पातळीवर आपला आणि आपल्या परिवाराचा, गावाचा, जिल्ह्याचा तुरा रोवला. असा हा आशिष ग्रामीण भागातील होतकरू युवकांसाठी ब्रँड आयकॉन ठरलाय.','2015/05/04','y','2'),(10,'Mumbai yethe Shiva cha melava ','Shiva sanghatana tarfe mahatma basweshwar jyanti pandharwadha samarop at yeshwantro Chavan sabhagra mumabai on 21-5-2015. Hojorechya sankhene upstheet raha ','2015/05/04','y','2'),(11,'Loha yethe 6 may la mahatma basweshwar jayanti','Sarva veershai Lingayat bandhwana aahwan karnyat yete ki dinnak 6 may 2015 rojji Shiva sanghatana tarfe mahatma basweshwar jayanti chi bhvya mirvnook nighnar aahe tari   aapan dupari 2 wajta Loha yethe hajarochya upsthit rahave ya rally che netrutva Shiva sanghtneche rastriya aadkshya prof manohar dhonde karnar aahet','2015/05/04','y','2'),(12,'Loha yethe 6 may la mahatma basweshwar jayanti','Sarva veershai Lingayat bandhwana aahwan karnyat yete ki dinnak 6 may 2015 rojji Shiva sanghatana tarfe mahatma basweshwar jayanti chi bhvya mirvnook nighnar aahe tari   aapan dupari 2 wajta Loha yethe hajarochya upsthit rahave ya rally che netrutva Shiva sanghtneche rastriya aadkshya prof manohar dhonde karnar aahet','2015/05/04','y','2'),(13,'Bannali (Dharmabad) 17 May la Mahatma Basweshwar jayanti:','Sarva veershev Lingayat bandhwana aahwan karnyat yete ki Dinnak 17may 2015 roji Time 4 vajta Shiva sanghatnechya tarfe mahatma Basweshwar jayanti chi bhue mirvonook Bannali yethe nighnar aahe tari aapan saru samaj bhadhuani upastit rahuave. Sayojak Chakresh Patil Bannalikar','2015/05/04','y','2'),(14,'जय शिवा ','जय शिवा \nदी ०६/०५/२०१५ रोजी लोहा येथे महात्मा बसवेश्वर जंयती\nसाजरी होत आहे तरी लोहा/ परीसरातील लिगांयत बांधवानी\nयेवुन आपली समाजाची ताकद दाखवावी','2015/05/04','y','2'),(15,'जय शिवा ','जय शिवा \nदी ०६/०५/२०१५ रोजी लोहा येथे महात्मा बसवेश्वर जंयती\nसाजरी होत आहे तरी लोहा/ परीसरातील लिगांयत बांधवानी\nयेवुन आपली समाजाची ताकद दाखवावी','2015/05/04','y','2'),(16,' दैनिक मडँर    दिनांक २९/४/२०१५','समाज  मंदीर जागेवर\nबांधकामास हरकत\nशहरातील  गंन ४ व५ च्या बोळीतील लिंगायत समाज मंदीर च्या जागेवर अनधिकृत बांधकाम करण्याचा प्रयत्न  आज \nसमाजातील काही लोकांनी  हाणुन पाङला या प्रकाराने त्या ठिकाणी  काही काळ तणाव ही निर्माण  झाला होता माञ \nअखेरीस ते बांधकाम   रोख ण्यात आले याबाबत मिळालेल्या  माहिती  नुसार शहरातील रथगली लिंगायत समाजाच्या पुरातन समाज मंदीर असून त्या  लगत जी.बी सोलंकी नामक इसम गेल्या अनेक वषाँपासून वास्तव्याला आहे त्यांनी या जागेवर बांधकाम करण्यास सुरुवात केल्याने लिंगायत समाजतील लोकांनी हरकत  घेतली शशिकांत मोगलाईकर नंदकिशोर लदे किशोर लिंगायत राजेश चांदणे सचिन कणँ तुषार लदे हषँल हेडे यांच्या  म्हणण्यानुसार ती संपुणँ जागा समाज  मंदीरराची असून वापर नसल्याने  सोलंकी यांना निवासा साठी वापरु  देण्यात  येत होती \nमाञ त्यांनी   जागेवर  पके बांधकाम करून ही जागाच बळकव ण्याचा प्रयत्न  केल्या ने तो समाजास अमान्य  असल्याचे  म्हटले आहे त्या वरून तेथे काही काळ तणाव निर्माण  झाला अखेरीस सोलंकी यांनी  सुरु केलेले बांधकाम बंद पाडण्यात  आले','2015/05/04','y','2'),(17,'शिवा संघटना 21 वा वर्धापन दिन होणार लंडन ला साजरा28 जानेवारी 2017 ','शिवा संघटना 21 वा वर्धापन दिन लंडन ला साजरा करणार \nशिवा संघटना संस्थापक तथा राष्ट्रीय अध्यक्ष, लिंगायत OBC आरक्षण प्रणेते, मा. प्रा. मनोहर धोंडे सरांनी केली घोषणा \n17 वा वर्धापन दिन मोठ्या उत्सहात श्रीलंकेला साजरा झालाय त्याच प्रमाणे दि. 28 जानेवारी 2015 रोजी शिवा संघटनेचा 21 वा वर्धापन दिन मोठ्या उत्सहात व आनंदात समाज बांधवांच्या व मा. प्रा. मनोहर धोंडे सर, शिवा संघटनेचे पदाधीकारी यांच्या सोबत या अलौकिक अनुभूतीचा प्रत्यक्ष अनुभव घेण्या साठी समाज बांधवांनी आप आपले नावे प्रत्येक जिल्ह्यातील शिवा संघटनेच्या जिल्हा अध्यक्षा किंवा तालुका अध्यक्षा कडे द्यावीत व आप आपले पासपोर्ट तयार करावे \nजय शिवा\n\nमनिष पंधाडे \nशिवा संघटना सोशल मिडीया महाराष्ट्र सहकारी \nशिवा संघटना बुलडाणा जिल्हा सरचिटनिस \n9225722655\n8149117900\n\n','2015/05/04','y','2'),(18,'चलो मुंबई   . . . दि. 21 मे 2015   शिवा संघटनेने साजरा करत असलेला महात्मा बसवेश्वर जयंती पंधर वाडा समारोप ','सर्व समाज बांधवानी महात्मा बसवेश्वर जयंती पंधर वाड्याचा समारोप दि. 21 मे 2015 रोजी \nमा. प्रा. मनोहर धोंडे सर व मंत्री महोदयाच्या प्रमुख उपस्थित होणार आहे \nतरी सर्वांनी उपस्थित रहावे\nजय शिवा\n\nमनिष पंधाडे \nशिवा संघटना \nजिल्हा बुलडाणा \n9225722655\n8149117900','2015/05/04','y','2'),(19,'जय शिवा ','उद्या लोहा येथे महात्मा बसवेश्वर यांची ८८४ वी जंयती \nशिवा संघटनेचे संस्थापक अध्यक्ष श्री मा प्रा  मनोहरजी\nधोंडे यांच्या उपस्थितीत साजरी होते आहे तरी तमाम लिंगायत \nबांधवानी आपली उपस्थिती दाखवावी व ठिक ७:०० वाजता \nलोहा येथिल व्यकंटेश्वरा मंगल कार्यालय मध्ये विरशैवाची तोफ \nधडाडनार आहे तरी त्यांचे विचार ऐकण्यासाठी सर्वानी उपस्थित \nराहवे \nहेच आमत्रंन समजावे \n      आपलाच नम्र\n     संतोष एम धोंडे \n      शिवा संघटना','2015/05/05','y','2'),(20,'जय शिवा ','उद्या लोहा येथे महात्मा बसवेश्वर यांची ८८४ वी जंयती \nशिवा संघटनेचे संस्थापक अध्यक्ष श्री मा प्रा  मनोहरजी\nधोंडे यांच्या उपस्थितीत साजरी होते आहे तरी तमाम लिंगायत \nबांधवानी आपली उपस्थिती दाखवावी व ठिक ७:०० वाजता \nलोहा येथिल व्यकंटेश्वरा मंगल कार्यालय मध्ये विरशैवाची तोफ \nधडाडनार आहे तरी त्यांचे विचार ऐकण्यासाठी सर्वानी उपस्थित \nराहवे \nहेच आमत्रंन समजावे \n      आपलाच नम्र\n     संतोष एम धोंडे \n      शिवा संघटना','2015/05/05','y','2'),(28,'जय शिवा ','जय शिवा ','2015/05/10','y','2'),(29,'जय शिवा','दि:- २१/०५/२०१५ रोजी यशवंतराव चव्हाण सभाग्रह येथे \nमहात्मा बसवेश्वर जंयतीचा पंधरवाडा समारोप साजरा होत \nआहे त्या कार्यक्रमास महाराष्ट्राचे मुख्यमंत्री देवेन्द्र फडनविस\nमुख्य अतिथी महनुन येत आहेत \nतसेच आपल्या समाजाची बुंलद तोफ विरशैव लिगांयत \nसम्राट प्रा मनोहरजी धोंडे यांचे विचार ऐकन्या साठी नांदेड \nजिल्ह्यातील सर्वानी ठीक दुपारी ४:०० वाजता नांदेड \nरेल्वे स्टेशन वर यावे ही नम्र विनंती \n      आपला नम्र \n     संतोष एम धोंडे  ','2015/05/12','y','2'),(31,'           शिवैक विवेक विरकर (मुंबई)','शिवा संघटनेचे मुंबईचे जिल्हाअध्यक्ष विवेकजी विरकर यांचे दि.15.5.2015 रोजी रात्री 12 वाजता हृदय विकाराने निधन झाले त्यांचे दुखःत्आम्ही  सहभागी आहोत....लद्दे अरुण( शिवा कर्मचारी महासंघ उत्तर महाराष्ट्र प्रमुख 8149639981\n','2015/05/16','y','2'),(32,'           शिवैक विवेक विरकर (मुंबई)','शिवा संघटनेचे मुंबईचे जिल्हाअध्यक्ष विवेकजी विरकर यांचे दि.15.5.2015 रोजी रात्री 12 वाजता हृदय विकाराने निधन झाले त्यांचे दुखःत्आम्ही  सहभागी आहोत....लद्दे अरुण( शिवा कर्मचारी महासंघ उत्तर महाराष्ट्र प्रमुख 8149639981\n','2015/05/16','y','2'),(38,'jai shiva','jai shiva','2015/05/16','n','2'),(39,'jai shiva','jai shiva','2015/05/16','n','2'),(40,'jai shiva','jai shiva','2015/05/16','n','2'),(41,'jai shiva','jai shiva','2015/05/17','n','2'),(42,'jai shiva','jai shiva','2015/05/17','n','2'),(43,'jai shiva','jai shiva','2015/05/17','n','2'),(44,'jai shiva','jai shiva','2015/05/17','n','2'),(45,'jai shiva','jai shiva','2015/05/17','n','2'),(46,'jai shiva','jai shiva','2015/05/17','n','2'),(47,'jai shiva','jai shiva','2015/05/17','n','2'),(48,'jai shiva','jai shiva','2015/05/17','n','2');
/*!40000 ALTER TABLE `oldernewsdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registeruser`
--

DROP TABLE IF EXISTS `registeruser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registeruser` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `email` varchar(1000) NOT NULL,
  `phone` decimal(20,0) NOT NULL,
  `position` varchar(1000) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `city` varchar(1000) NOT NULL,
  `pannumber` varchar(1000) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `gender` varchar(1000) NOT NULL,
  `matrialstatus` varchar(1000) NOT NULL,
  `age` varchar(1000) NOT NULL,
  `country` varchar(1000) NOT NULL,
  `department` varchar(1000) NOT NULL,
  `deviceid` varchar(1000) NOT NULL,
  `lastupdatedate` varchar(1000) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `verify` varchar(1000) NOT NULL,
  `status` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`,`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registeruser`
--

LOCK TABLES `registeruser` WRITE;
/*!40000 ALTER TABLE `registeruser` DISABLE KEYS */;
INSERT INTO `registeruser` VALUES (1,'bhushan ladde','','',8055925868,'','nasik','','male','','','india','','bb89c7e8dd5d6bf4','2015/05/11','bhushan123','84765','N'),(2,'bhushan arun ladde','','',8793501156,'','nasik','','male','','','india','','bb89c7e8dd5d6bf4','2015/05/12','1234','76772','N'),(3,'bhushan','','',918793501156,'','Nasik','','hh','','','inndia','','bb89c7e8dd5d6bf4','2015/05/12','bhushan','13893','N'),(4,'Ladde Arun kashinath','','',8149639981,'','Nashik','','Male','','','India','','5ea8c2557aa012c9','2015/05/16','Arun','29178','N'),(5,'          Ladde Arun Kashinath','','',8149639981,'','   Nashik','','   Male','','','      India','','5ea8c2557aa012c9','2015/05/17','Arun','93777','N'),(6,'          Ladde Arun Kashinath','','',8149639981,'','   Nashik','','   Male','','','      India','','5ea8c2557aa012c9','2015/05/17','Arun','26261','N'),(7,'bbushab','','',12335577,'','vagah','','gahau','','','gbagah','','bb89c7e8dd5d6bf4','2015/05/17','fff','96609','N'),(8,'bbushab','','',12335577,'','vagah','','gahau','','','gbagah','','bb89c7e8dd5d6bf4','2015/05/17','fff','88430','N'),(9,'bbushab','','',12335577,'','vagah','','gahau','','','gbagah','','bb89c7e8dd5d6bf4','2015/05/17','fff','64515','N'),(10,'gagaga','','',1244555,'','vbaban','','hshaj','','','bana','','bb89c7e8dd5d6bf4','2015/05/17','gshahsh','1083','N');
/*!40000 ALTER TABLE `registeruser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-17  9:11:06
