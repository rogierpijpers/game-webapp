

### README

EERST:

-eerst moet de wsdl gemaakt worden! daarna kan maven pas builden (d.m.v. clean install) en de benodigde dependencies ophalen

-GameService klasse maken we vanaf de wsdl, vandaar dat ik die nog niet heb aangemaakt

-Je kan voor de XSD van getGameDetails natuurlijk de Game klasse reverse engineren



VERDER:

-GameFactory naam is veranderd naar GameFacade.. leek me beter

-In de pom.xml heb ik de org.json dependency toegevoegd, die kan je gebruiken om JSON te vreten (voor de DAO's dus)

-Voor je eigen DAO klassen kan je ff een Test met een main schrijven, het maven project
kan namelijk pas gebuild worden zonder errors als de wsdl gemaakt is.
