CREATE TABLE `publisher` (
  `id_publisher` int(11) UNSIGNED NOT NULL auto_increment,
  `publisher` varchar(256) NOT NULL,
  primary key (id_publisher)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Publisher`
--

INSERT INTO `publisher` (`id_publisher`, `publisher`) VALUES
(1, ''),
(2, '65.pole'),
(3, 'Academia'),
(5, 'ADAM'),
(6, 'Adonai'),
(7, 'AF 167'),
(8, 'AFSF'),
(9, 'AG kult'),
(10, 'Agave'),
(11, 'Agnes'),
(12, 'Áka'),
(13, 'Akcent'),
(14, 'Akropolis'),
(15, 'Albatros'),
(18, 'Albor vitae'),
(19, 'Aleš Čeněk'),
(20, 'Aleš Skřivan'),
(21, 'Alfa publishing'),
(22, 'Allan'),
(23, 'Alman'),
(24, 'Alois Hynek'),
(25, 'Alpress'),
(26, 'Alšovoa jihočeská galerie'),
(27, 'Alter'),
(28, 'Ametyst'),
(29, 'Amos'),
(30, 'Amulet'),
(31, 'Anag'),
(32, 'Ando Publishing'),
(33, 'AOPK ČR'),
(34, 'Arcadia'),
(35, 'Argo'),
(39, 'Artech House'),
(40, 'Artur'),
(41, 'Atlantis'),
(42, 'ATP'),
(43, 'Atrium'),
(44, 'Aurora'),
(45, 'Aventinum'),
(46, 'Award publications'),
(47, 'Axióma'),
(48, 'B&N'),
(49, 'B4U'),
(50, 'Baedeker'),
(51, 'Balios'),
(52, 'Bankovní institut'),
(53, 'Banshies'),
(54, 'Baobab'),
(55, 'Baronet'),
(57, 'Barrister & Principal'),
(59, 'BB/Art'),
(60, 'Bearstache Book'),
(61, 'Beta'),
(62, 'Blok'),
(64, 'Bloomsbury publishing'),
(66, 'BMSS-START'),
(67, 'Bohemia Books'),
(68, 'Bon Art'),
(69, 'Brimar'),
(70, 'Brio'),
(71, 'C.H.Beck'),
(72, 'Cambridge University Press'),
(73, 'Carpe diem'),
(74, 'CDK'),
(75, 'cinema'),
(76, 'Classic'),
(77, 'Codex'),
(78, 'Columbus'),
(79, 'Computer press'),
(80, 'ComputerMedia'),
(81, 'CooBoo'),
(82, 'CREW'),
(83, 'Crown Publishers'),
(85, 'Cykloknihy'),
(86, 'Cylindr'),
(87, 'Česká kosmická kancelář'),
(88, 'Česká televize'),
(89, 'Československý spisovatel'),
(91, 'Český klub'),
(92, 'Český spisovatel'),
(93, 'Čtyřlístek'),
(94, 'Daranus'),
(95, 'DeAgostini'),
(96, 'Del Rey'),
(97, 'Delphin verlag'),
(98, 'DharmaGaia'),
(99, 'Dialog'),
(100, 'Dita'),
(101, 'DK publishing'),
(102, 'Dobra'),
(103, 'Dokořán'),
(104, 'DOMINO'),
(105, 'dona'),
(106, 'Doplněk'),
(107, 'Druhé Město'),
(108, 'Družstevní práce'),
(109, 'Dybbuk'),
(110, 'E. Šolc'),
(111, 'East publishing'),
(112, 'Economia'),
(113, 'Egmont'),
(114, 'Ekopress'),
(115, 'ELK'),
(116, 'Eminent'),
(117, 'eNav'),
(118, 'Epocha'),
(120, 'ETC Publishing'),
(121, 'Eupress'),
(122, 'Eurolex Bohemia'),
(123, 'Everyman\'s Library'),
(124, 'Fagotto Books'),
(125, 'Falmingo'),
(126, 'Fantom print'),
(127, 'Fontána'),
(128, 'Fortuna Print'),
(129, 'Fr. Borový'),
(130, 'Fragment'),
(132, 'Franciscan Printing Press'),
(133, 'Fraus'),
(134, 'freytag & berndt'),
(135, 'Fuego'),
(136, 'Futura'),
(137, 'G&W'),
(138, 'GABI'),
(140, 'Galén'),
(141, 'gallery'),
(142, 'Garamond'),
(143, 'Gemini'),
(144, 'GKP Praha'),
(145, 'GplusG'),
(146, 'Grada'),
(147, 'Granát'),
(148, 'H+H'),
(149, 'HAK'),
(150, 'Hanácké vydavatelství'),
(151, 'Harper Collins'),
(153, 'Havran'),
(154, 'Haynes'),
(155, 'Hodder & Stroughton'),
(157, 'Horizont'),
(158, 'Host'),
(159, 'Hynek'),
(160, 'Ikar'),
(161, 'Infoa'),
(162, 'ing. V. Macek'),
(163, 'ISU'),
(164, 'Ivo Železný'),
(165, 'Jan Laichter'),
(166, 'Jan Melvil Publishing'),
(167, 'Jerome'),
(168, 'Jilm'),
(169, 'JKM'),
(170, 'Jos. L. Švíkal'),
(171, 'Jos. R. Vilímek'),
(172, 'Josef Hokr'),
(173, 'Jota'),
(174, 'Junior'),
(175, 'Karel Petřík'),
(176, 'Karmelitánské nakladatelství'),
(177, 'Karolinum'),
(178, 'Kartografie Praha'),
(179, 'KAVA-PECH'),
(180, 'Kentaur'),
(181, 'Klokan'),
(182, 'Klub J. Vernea'),
(183, 'Klub Julese Vernea'),
(184, 'Kniha Zlín'),
(185, 'Knihy nejen pro bohaté'),
(186, 'Knižní klub'),
(187, 'Kopp'),
(188, 'Kratochvíl'),
(189, 'Kredit'),
(190, 'Kruh'),
(191, 'Kvartus Media'),
(192, 'L. Marek'),
(193, 'Labyrint'),
(194, 'Laser'),
(196, 'Leda'),
(197, 'Leges'),
(198, 'Leonardo'),
(199, 'Levné knihy'),
(201, 'Librex'),
(202, 'Libri'),
(203, 'Lidové nakladatelství'),
(205, 'Lidové noviny'),
(206, 'Lika'),
(207, 'LIKA KLUB'),
(208, 'Linde'),
(209, 'Listen'),
(210, 'Lonely Planet'),
(211, 'Longman'),
(212, 'Lucka Bohemia'),
(213, 'Lunarion'),
(214, 'Macmillan'),
(215, 'Magazine'),
(216, 'Magna'),
(217, 'Magnet'),
(218, 'MAGNET-PRESs'),
(219, 'Máj'),
(220, 'Management Press'),
(222, 'Maťa'),
(223, 'MC'),
(224, 'Meander'),
(225, 'Melandrium'),
(227, 'Melantrich'),
(228, 'Menasha Ridge'),
(229, 'Metafora'),
(230, 'Michal Zeman Observatory Media'),
(231, 'Milenium'),
(232, 'Milenium Publishing'),
(233, 'Ministerstvo informací'),
(234, 'Mladá Fronta'),
(235, 'Mladé Letá'),
(237, 'Moba'),
(238, 'moderniProgramovani'),
(239, 'Monika Elšíková'),
(240, 'Motto'),
(241, 'MU'),
(242, 'MUP'),
(243, 'Musee de Louvre'),
(244, 'Musei Vaticani'),
(245, 'Mustang'),
(246, 'Nakladatelství F.Kafky'),
(247, 'Nakladatelství Svoboda'),
(248, 'Národní divadlo'),
(249, 'Naše vojsko'),
(250, 'Nauka'),
(251, 'Nava'),
(252, 'Návrat'),
(253, 'Nelles Verlag'),
(254, 'Netopejr'),
(255, 'NG'),
(256, 'Národní Galerie'),
(257, 'Norton & company'),
(258, 'Octopus Books'),
(259, 'Odeon'),
(260, 'OIKOYMENH'),
(261, 'OK centrum'),
(262, 'Oldag'),
(263, 'Olympia'),
(264, 'Orac'),
(265, 'Orbis'),
(266, 'Orbis Pictus'),
(267, 'Orbit'),
(268, 'Ottovo nakladatelství'),
(269, 'Oxford'),
(270, 'Oxford University Press'),
(272, 'Panorama'),
(273, 'Panton'),
(274, 'Paseka'),
(275, 'PedF UK'),
(277, 'Penguin Books'),
(278, 'Pěnkava'),
(279, 'Perfekt'),
(280, 'Perseus'),
(281, 'Peter Haddock'),
(282, 'Petr Prchal'),
(283, 'Petrkov'),
(284, 'Petrov'),
(285, 'Pistorius'),
(286, 'Plejáda'),
(287, 'Plot'),
(288, 'Plus'),
(289, 'Polaris'),
(290, 'Polyglot'),
(292, 'Portál'),
(293, 'Práce'),
(294, 'Pragma'),
(295, 'PragokoncertBohemia'),
(296, 'Pragoline'),
(297, 'Práh'),
(298, 'Príroda'),
(300, 'Professional Publishing'),
(301, 'Profil'),
(302, 'Progress Moskva'),
(303, 'Prometheus'),
(304, 'Prospektrum'),
(305, 'Prostor'),
(306, 'Puffin Books'),
(307, 'R. Prombergr'),
(308, 'R.S.G.'),
(309, 'Radix'),
(310, 'Random House'),
(311, 'Readers Digest Výběr'),
(313, 'Rebo productions'),
(314, 'Regia'),
(315, 'Repronis'),
(316, 'Respekt'),
(317, 'Rodiče'),
(318, 'Romeo'),
(319, 'Rozmluvy'),
(320, 'Rybka publishers'),
(321, 'Saga'),
(322, 'Scientia'),
(324, 'Scribner'),
(325, 'SČUG Hollar'),
(326, 'Sdružení Umělců Slezských v Opavě'),
(327, 'Sfinx'),
(328, 'Schneider'),
(329, 'Sid & NERo'),
(330, 'Simon a Simon Publishers'),
(332, 'Skřivan'),
(333, 'SLAN'),
(334, 'Slavonická renesanční společnost'),
(335, 'Slon'),
(336, 'Slovart'),
(337, 'Slunovrat'),
(338, 'Smart Press'),
(339, 'Smena'),
(340, 'SNDK'),
(341, 'SNDK/Albatros'),
(342, 'SNKLHU'),
(344, 'SNTL'),
(345, 'Softpress'),
(347, 'Soukup & David'),
(348, 'SPN'),
(350, 'Straky na vrbě'),
(351, 'Středočeské nakladatelství'),
(352, 'STUDIO trnka'),
(353, 'SUN'),
(354, 'Supraphon'),
(355, 'Sursum'),
(356, 'Svatošovo nakladatelství'),
(357, 'Svět sovětů'),
(358, 'Svoboda'),
(360, 'Svojtka & co'),
(361, 'Synergie'),
(362, 'Štorch-Marien'),
(363, 'Šulc a spol.'),
(364, 'Talpres'),
(366, 'Taschen'),
(367, 'Tatran'),
(368, 'The Readers Library'),
(369, 'Thovt'),
(370, 'Tichá Byzanc'),
(371, 'TOP Agency'),
(372, 'Torst'),
(373, 'Toužimský & Moravec'),
(375, 'Transworld Publishers'),
(376, 'Triton'),
(377, 'Tvarohová-Kolář'),
(378, 'Tyrland'),
(379, 'Umitaria'),
(380, 'ÚMV'),
(381, 'Universum'),
(382, 'USIA'),
(383, 'Vasilis Kouvidis'),
(384, 'Vašut'),
(385, 'Verlag de Schwaneberger Album'),
(386, 'Veronika Reynková'),
(387, 'Vertus Via'),
(388, 'Via Facti'),
(390, 'Victoria publishing'),
(391, 'Vintage'),
(392, 'vlastní'),
(393, 'Volvox Globator'),
(394, 'Votobia'),
(395, 'VŠB - TU Ostrava'),
(396, 'VŠE'),
(397, 'Všehrd'),
(398, 'VŠFS'),
(399, 'Vyšehrad'),
(400, 'Vyturys'),
(401, 'Wald press'),
(402, 'Wales'),
(403, 'Wiley Publishing'),
(404, 'Winston Smith'),
(405, 'Wizards of the Coast'),
(406, 'Wolf Publishing'),
(407, 'Wolters Kluwer'),
(408, 'Wordsworth Classics'),
(409, 'World international publishing'),
(410, 'X-egem'),
(411, 'XYZ'),
(412, 'Yad Izhak Ben-Zvi'),
(413, 'ZČU Plzeň'),
(415, 'Zoner Press'),
(417, 'ZOO Praha'),
(418, 'Zvon'),
(419, 'Bizbooks'),
(420, 'Grimmus');
