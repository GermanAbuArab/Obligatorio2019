import entidades.*;
import tads.hash.ElementoYaExistenteException;
import tads.hash.Hash;
import tads.hash.NoExisteElemento;
import tads.hash.NodoHash;
import tads.heap.HeapImpl;
import tads.heap.NodeHeap;

import java.util.ArrayList;


class Consultas {


    static void consultaUno(int tipo) {
        NodoHash<Athlete, Integer>[] temp = Repositorio.getHashAtleta().getHash();
        if (tipo == 1) {

            HeapImpl<Integer, Athlete> medallasOro = new HeapImpl<>(150000, 1);
            for (NodoHash<Athlete, Integer> athleteIntegerNodoHash : temp) {
                if (athleteIntegerNodoHash != null) {
                    medallasOro.agregar(athleteIntegerNodoHash.getValor().getMedallasOro(), athleteIntegerNodoHash.getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallasOro.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas oro: "
                        + athlete.getMedallasOro() + " - Año minimo: " + athlete.getAnioMinimoO() + " - Año maximo: " + athlete.getAnioMaximoO()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }
        } else if (tipo == 2) {
            HeapImpl<Integer, Athlete> medallasPlata = new HeapImpl<>(150000, 1);
            for (NodoHash<Athlete, Integer> athleteIntegerNodoHash : temp) {
                if (athleteIntegerNodoHash != null) {
                    medallasPlata.agregar(athleteIntegerNodoHash.getValor().getMedallasPlata(), athleteIntegerNodoHash.getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallasPlata.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas plata: "
                        + athlete.getMedallasPlata() + " - Año minimo: " + athlete.getAnioMinimoP() + " - Año maximo: " + athlete.getAnioMaximoP()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }

        } else if (tipo == 3) {
            HeapImpl<Integer, Athlete> medallasBronce = new HeapImpl<>(150000, 1);
            for (NodoHash<Athlete, Integer> athleteIntegerNodoHash : temp) {
                if (athleteIntegerNodoHash != null) {
                    medallasBronce.agregar(athleteIntegerNodoHash.getValor().getMedallasBronce(), athleteIntegerNodoHash.getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallasBronce.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas bronce: "
                        + athlete.getMedallasBronce() + " - Año minimo: " + athlete.getAnioMinimoB() + " - Año maximo: " + athlete.getAnioMaximoB()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }
        } else if (tipo == 4) {
            HeapImpl<Integer, Athlete> medallas = new HeapImpl<>(150000, 1);
            for (NodoHash<Athlete, Integer> athleteIntegerNodoHash : temp) {
                if (athleteIntegerNodoHash != null) {
                    medallas.agregar(athleteIntegerNodoHash.getValor().getMedallas(), athleteIntegerNodoHash.getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallas.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas: "
                        + athlete.getMedallas() + " - Año minimo: " + athlete.getAnioMinimo() + " - Año maximo: " + athlete.getAnioMaximo()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }
        }


    }

    static void consultaDos(int tipo) {

        Hash<Integer, String> hashMedOro = new Hash<>(330);
        Hash<Integer, String> hashMedPlata = new Hash<>(330);
        Hash<Integer, String> hashMedBronce = new Hash<>(330);
        Hash<Integer, String> hashMedTotal = new Hash<>(330);
        NodoHash<NationalOlympicCommittee, String>[] hashNOC = Repositorio.getHashNOC().getHash();
        NodoHash<Integer, String>[] temp1 = hashMedBronce.getHash();
        NodoHash<Integer, String>[] temp2 = hashMedPlata.getHash();
        NodoHash<Integer, String>[] temp3 = hashMedOro.getHash();
        NodoHash<Integer, String>[] temp4 = hashMedTotal.getHash();
        for (NodoHash<NationalOlympicCommittee, String> nationalOlympicCommitteeStringNodoHash : hashNOC) {
            if (nationalOlympicCommitteeStringNodoHash != null) {

                if (!hashMedBronce.pertenece(nationalOlympicCommitteeStringNodoHash.getValor().getRegion())) {
                    try {
                        hashMedBronce.insertar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion(), nationalOlympicCommitteeStringNodoHash.getValor().getMedallasBronce());
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                } else {
                    Integer cantBronce = hashMedBronce.getValor(nationalOlympicCommitteeStringNodoHash.getValor().getRegion());
                    cantBronce = cantBronce + nationalOlympicCommitteeStringNodoHash.getValor().getMedallasBronce();
                    try {
                        hashMedBronce.borrar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion());
                    } catch (NoExisteElemento noExisteElemento) {
                        System.out.println("Esto no deberia de pasar");
                    }
                    try {
                        hashMedBronce.insertar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion(), cantBronce);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                }

                if (!hashMedPlata.pertenece(nationalOlympicCommitteeStringNodoHash.getValor().getRegion())) {
                    try {
                        hashMedPlata.insertar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion(), nationalOlympicCommitteeStringNodoHash.getValor().getMedallasPlata());
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                } else {
                    Integer cantPlata = hashMedPlata.getValor(nationalOlympicCommitteeStringNodoHash.getValor().getRegion());
                    cantPlata = cantPlata + nationalOlympicCommitteeStringNodoHash.getValor().getMedallasPlata();
                    try {
                        hashMedPlata.borrar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion());
                    } catch (NoExisteElemento noExisteElemento) {
                        System.out.println("Esto no deberia de pasar");
                    }
                    try {
                        hashMedPlata.insertar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion(), cantPlata);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                }

                if (!hashMedOro.pertenece(nationalOlympicCommitteeStringNodoHash.getValor().getRegion())) {
                    try {
                        hashMedOro.insertar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion(), nationalOlympicCommitteeStringNodoHash.getValor().getMedallasOro());
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                } else {
                    Integer cantOro = hashMedOro.getValor(nationalOlympicCommitteeStringNodoHash.getValor().getRegion());
                    cantOro = cantOro + nationalOlympicCommitteeStringNodoHash.getValor().getMedallasOro();
                    try {
                        hashMedOro.borrar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion());
                    } catch (NoExisteElemento noExisteElemento) {
                        System.out.println("Esto no deberia de pasar");
                    }
                    try {
                        hashMedOro.insertar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion(), cantOro);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                }
                if (!hashMedTotal.pertenece(nationalOlympicCommitteeStringNodoHash.getValor().getRegion())) {
                    try {
                        int medallasTotales = nationalOlympicCommitteeStringNodoHash.getValor().getMedallasBronce() + nationalOlympicCommitteeStringNodoHash.getValor().getMedallasPlata() + nationalOlympicCommitteeStringNodoHash.getValor().getMedallasOro();
                        hashMedTotal.insertar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion(), medallasTotales);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                } else {
                    Integer cantMedallas = hashMedTotal.getValor(nationalOlympicCommitteeStringNodoHash.getValor().getRegion());
                    cantMedallas = cantMedallas + nationalOlympicCommitteeStringNodoHash.getValor().getMedallas();
                    try {
                        hashMedTotal.borrar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion());
                    } catch (NoExisteElemento noExisteElemento) {
                        System.out.println("Esto no deberia de pasar");
                    }
                    try {
                        hashMedTotal.insertar(nationalOlympicCommitteeStringNodoHash.getValor().getRegion(), cantMedallas);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                }


            }
        }

        if (tipo == 1) {

            HeapImpl<Integer, String> medallasOro = new HeapImpl<>(330, 1);
            for (NodoHash<Integer, String> integerStringNodoHash : temp3) {
                if (integerStringNodoHash != null) {
                    medallasOro.agregar(integerStringNodoHash.getValor(), integerStringNodoHash.getClave());
                }
            }
            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasOro.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        } else if (tipo == 2) {

            HeapImpl<Integer, String> medallasPlata = new HeapImpl<>(330, 1);
            for (NodoHash<Integer, String> integerStringNodoHash : temp2) {
                if (integerStringNodoHash != null) {
                    medallasPlata.agregar(integerStringNodoHash.getValor(), integerStringNodoHash.getClave());
                }
            }
            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasPlata.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        } else if (tipo == 3) {

            HeapImpl<Integer, String> medallasBronce = new HeapImpl<>(330, 1);
            for (NodoHash<Integer, String> integerStringNodoHash : temp1) {
                if (integerStringNodoHash != null) {
                    medallasBronce.agregar(integerStringNodoHash.getValor(), integerStringNodoHash.getClave());
                }
            }
            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasBronce.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        } else if (tipo == 4) {

            HeapImpl<Integer, String> medallasTotal = new HeapImpl<>(330, 1);
            for (NodoHash<Integer, String> integerStringNodoHash : temp4) {
                if (integerStringNodoHash != null) {
                    medallasTotal.agregar(integerStringNodoHash.getValor(), integerStringNodoHash.getClave());
                }
            }
            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasTotal.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        }
    }

    static void consultaTres() {
        Hash<NodoHash<ArrayList<Athlete>, Integer>, String> organizacion = new Hash<>(1000000);
        ArrayList<AthleteOlympicParticipation> participaciones = Repositorio.getParticip();
        for (int i = 0; i < participaciones.size(); i++) {
            if (participaciones.get(i) == null) {
                i = participaciones.size();
            } else {
                AthleteOlympicParticipation temp = participaciones.get(i);
                if (organizacion.pertenece(temp.getJuegoOlimpico().getName())) {
                    if (!organizacion.getValor(temp.getJuegoOlimpico().getName()).getValor().contains(temp.getAtlteta())) {
                        if (temp.getAtlteta().getSex() == SexType.FEMALE) {
                            Integer viejaKey = organizacion.getValor(temp.getJuegoOlimpico().getName()).getClave();
                            organizacion.getValor(temp.getJuegoOlimpico().getName()).setClave(viejaKey + 1);
                            organizacion.getValor(temp.getJuegoOlimpico().getName()).getValor().add(temp.getAtlteta());
                        }
                    }
                } else {
                    ArrayList<Athlete> inicial = new ArrayList<>(100000);
                    NodoHash<ArrayList<Athlete>, Integer> nodo = new NodoHash<>(inicial, 0, false);
                    try {
                        organizacion.insertar(temp.getJuegoOlimpico().getName(), nodo);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("falla extrema");
                    }
                }
            }

        }
        HeapImpl<Integer, String> mayorFemeninas = new HeapImpl<>(1000, 1);
        NodoHash<NodoHash<ArrayList<Athlete>, Integer>, String>[] paraHeap = organizacion.getHash();
        for (NodoHash<NodoHash<ArrayList<Athlete>, Integer>, String> nodoHashStringNodoHash : paraHeap) {
            if (nodoHashStringNodoHash != null) {
                mayorFemeninas.agregar(nodoHashStringNodoHash.getValor().getClave(), nodoHashStringNodoHash.getClave());
            }
        }

        Hash<OlympicGame, String> auxiliar = Repositorio.getHashGames();

        for (int i = 0; i < 10; i++) {

            NodeHeap<Integer, String> temp = mayorFemeninas.obtenerYEliminar();
            OlympicGame temp2 = auxiliar.getValor(temp.getData());
            System.out.println("Edicion: " + temp2.getName() + " - Año: " + temp2.getYear() + " - Cantidad de participantes femeninos:" + temp.getKey());

        }

    }

    static void consultaCuatro(boolean tipo) {
        SexType sexoAux = SexType.FEMALE;
        if (tipo) {
            sexoAux = SexType.MALE;
        }
        Hash<NodoHash<ArrayList<Athlete>, Integer>, String> organizacion = new Hash<>(1000000);
        ArrayList<AthleteOlympicParticipation> participaciones = Repositorio.getParticip();
        for (int i = 0; i < participaciones.size(); i++) {
            if (participaciones.get(i) == null) {
                i = participaciones.size();
            } else {
                AthleteOlympicParticipation temp = participaciones.get(i);
                if (organizacion.pertenece(temp.getEvento().getName())) {
                    if (!organizacion.getValor(temp.getEvento().getName()).getValor().contains(temp.getAtlteta())) {
                        if (temp.getAtlteta().getSex() == sexoAux) {
                            Integer viejaKey = organizacion.getValor(temp.getEvento().getName()).getClave();
                            organizacion.getValor(temp.getEvento().getName()).setClave(viejaKey + 1);
                            organizacion.getValor(temp.getEvento().getName()).getValor().add(temp.getAtlteta());
                        }
                    }
                } else {
                    ArrayList<Athlete> inicial = new ArrayList<>(100000);
                    NodoHash<ArrayList<Athlete>, Integer> nodo = new NodoHash<>(inicial, 0, false);
                    try {
                        organizacion.insertar(temp.getEvento().getName(), nodo);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("falla extrema");
                    }
                }
            }

        }

        HeapImpl<Integer, String> mayor = new HeapImpl<>(1000, 1);
        NodoHash<NodoHash<ArrayList<Athlete>, Integer>, String>[] paraHeap = organizacion.getHash();

        for (NodoHash<NodoHash<ArrayList<Athlete>, Integer>, String> nodoHashStringNodoHash : paraHeap) {
            if (nodoHashStringNodoHash != null) {
                mayor.agregar(nodoHashStringNodoHash.getValor().getClave(), nodoHashStringNodoHash.getClave());
            }
        }

        Hash<Event, String> auxiliar = Repositorio.getHashEventos();

        for (int i = 0; i < 5; i++) {

            NodeHeap<Integer, String> temp = mayor.obtenerYEliminar();
            Event temp3 = auxiliar.getValor(temp.getData());
            System.out.println("Competicion: " + temp3.getName() + " - Deporte: " + temp3.getDeporte().getName() + " - Sexo: " + sexoAux + " - Cantidad de participantes :" + temp.getKey());

        }
    }

    static void consultaCinco(long min, long max) {

        Hash<NodoHash<ArrayList<Athlete>, Float[]>, String> organizacion = new Hash<>(1000000); // la calve va a ser cantidad de los atreltas del equipio dividio la cantidad de medalla
        ArrayList<AthleteOlympicParticipation> participaciones = Repositorio.getParticip();


        for (int i = 0; i < participaciones.size(); i++) {
            if (participaciones.get(i) == null) {
                i = participaciones.size();
            } else {
                AthleteOlympicParticipation temp = participaciones.get(i);
                if (temp.getJuegoOlimpico().getYear() >= min && temp.getJuegoOlimpico().getYear() <= max) {
                    if (organizacion.pertenece(temp.getAtlteta().getTeam().getName())) { //existe equipo
                        if (organizacion.getValor(temp.getAtlteta().getTeam().getName()).getValor().contains(temp.getAtlteta()) &&
                                temp.getMedal() != null) { //si tiene al atleta y tiene medalla
                            Float medallas = organizacion.getValor(temp.getAtlteta().getTeam().getName()).getClave()[1]; //pos 1 es medallas
                            organizacion.getValor(temp.getAtlteta().getTeam().getName()).getClave()[1] = medallas + 1;
                        } else { //no tiene al atleta
                            Athlete aAgregar = temp.getAtlteta();
                            organizacion.getValor(temp.getAtlteta().getTeam().getName()).getValor().add(aAgregar);
                            Float cantAtletas = organizacion.getValor(temp.getAtlteta().getTeam().getName()).getClave()[0];
                            organizacion.getValor(temp.getAtlteta().getTeam().getName()).getClave()[0] = cantAtletas + 1;
                            if (temp.getMedal() != null) { //pero tiene medalla
                                Float medallas = organizacion.getValor(temp.getAtlteta().getTeam().getName()).getClave()[1];
                                organizacion.getValor(temp.getAtlteta().getTeam().getName()).getClave()[1] = medallas + 1;
                            }
                        }
                    } else {  //no existe equipo
                        ArrayList<Athlete> laLista = new ArrayList<>();
                        laLista.add(temp.getAtlteta());
                        Float[] elVector = new Float[2];
                        elVector[0] = 1f;
                        if (temp.getMedal() != null) {
                            elVector[1] = 1f;
                        } else {
                            elVector[1] = 0f;
                        }
                        NodoHash<ArrayList<Athlete>, Float[]> laData = new NodoHash<>(laLista, elVector, false);
                        try {
                            organizacion.insertar(temp.getAtlteta().getTeam().getName(), laData);
                        } catch (ElementoYaExistenteException e) {
                            System.out.println("falla total");
                        }

                    }
                }
            }
        }

        HeapImpl<Float, NodoHash<String, Float[]>> paraDevolver = new HeapImpl<>(10000000, 1);
        NodoHash<NodoHash<ArrayList<Athlete>, Float[]>, String>[] paraHeap = organizacion.getHash();

        for (NodoHash<NodoHash<ArrayList<Athlete>, Float[]>, String> nodoHashStringNodoHash : paraHeap) {
            if (nodoHashStringNodoHash != null) {
                Float[] paraNodo = new Float[2];
                paraNodo[0] = nodoHashStringNodoHash.getValor().getClave()[0];
                paraNodo[1] = nodoHashStringNodoHash.getValor().getClave()[1];
                NodoHash<String, Float[]> nodo = new NodoHash<>(nodoHashStringNodoHash.getClave(), paraNodo, false);
                paraDevolver.agregar(nodoHashStringNodoHash.getValor().getClave()[1] / nodoHashStringNodoHash.getValor().getClave()[0], nodo);
            }
        }
        if (organizacion.getCantElementos() != 0) {
            for (int i = 0; i < 5; i++) {

                NodeHeap<Float, NodoHash<String, Float[]>> temp = paraDevolver.obtenerYEliminar();
                String equipo = temp.getData().getValor();
                Float cantComp = temp.getData().getClave()[0];
                Float cantMed = temp.getData().getClave()[1];
                System.out.println("Equipo: " + equipo + " - Cantidad de competidores: " + cantComp + " - Cantidad de medallas: " + cantMed);
            }
        } else {
            System.out.println("No se registran juegos olimpicos entre esas fechas");
        }
    }


    static void consultaDos2(int tipo) {
        HeapImpl<Integer, String> medallasPlata = new HeapImpl<>(330, 1);

        HeapImpl<Integer, String> medallasBronce = new HeapImpl<>(330, 1);
        HeapImpl<Integer, String> medallasTotal = new HeapImpl<>(330, 1);
        HeapImpl<Integer, String> medallasOro = new HeapImpl<>(330, 1);

        Hash<NodoHash<ArrayList<Athlete>, Integer[]>, String> organizacion = new Hash<>(1000000); // la calve va a ser cantidad de los atreltas del equipio dividio la cantidad de medalla
        ArrayList<AthleteOlympicParticipation> participaciones = Repositorio.getParticip();

        for (int i = 0; i < participaciones.size(); i++) { // En esta parte guardamos llos medallas por regiones y tenemos la cant de medallas
            if (participaciones.get(i) == null) {
                i = participaciones.size();
            } else {
                AthleteOlympicParticipation temp = participaciones.get(i);
                if (!organizacion.pertenece(temp.getAtlteta().getNatOlimpic().getRegion())) { // si no existe la region la creo
                    ArrayList<Athlete> laLista = new ArrayList<>();
                    Integer[] elVector = new Integer[3];
                    elVector[0] = 0;
                    elVector[1] = 0;
                    elVector[2] = 0;
                    NodoHash<ArrayList<Athlete>, Integer[]> laData = new NodoHash<>(laLista, elVector, false);
                    try {
                        organizacion.insertar(temp.getAtlteta().getNatOlimpic().getRegion(), laData);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Falla total");
                    }
                }

                if (temp.getMedal() != null) {
                    switch (temp.getMedal()) {
                        case BRONZE:
                            Integer[] clavevieja = organizacion.getValor(temp.getAtlteta().getNatOlimpic().getRegion()).getClave();
                            clavevieja[2]++;
                            organizacion.getValor(temp.getAtlteta().getNatOlimpic().getRegion()).setClave(clavevieja);
                            break;
                        case SILVER:
                            Integer[] clavevieja2 = organizacion.getValor(temp.getAtlteta().getNatOlimpic().getRegion()).getClave();
                            clavevieja2[1]++;
                            organizacion.getValor(temp.getAtlteta().getNatOlimpic().getRegion()).setClave(clavevieja2);
                            break;
                        case GOLD:
                            Integer[] clavevieja3 = organizacion.getValor(temp.getAtlteta().getNatOlimpic().getRegion()).getClave();
                            clavevieja3[0]++;
                            organizacion.getValor(temp.getAtlteta().getNatOlimpic().getRegion()).setClave(clavevieja3);
                            break;

                    }
                }
            }
        }
        NodoHash<NodoHash<ArrayList<Athlete>, Integer[]>, String>[] paraHeap = organizacion.getHash();
        for (NodoHash<NodoHash<ArrayList<Athlete>, Integer[]>, String> nodoHashStringNodoHash : paraHeap) {
            if (nodoHashStringNodoHash != null) {
                Integer[] paraNodo = new Integer[3];

                paraNodo[0] = nodoHashStringNodoHash.getValor().getClave()[0];
                paraNodo[1] = nodoHashStringNodoHash.getValor().getClave()[1];
                paraNodo[2] = nodoHashStringNodoHash.getValor().getClave()[2];
                Integer concatenacion = paraNodo[0] + paraNodo[1] + paraNodo[2];
                medallasBronce.agregar(paraNodo[2], nodoHashStringNodoHash.getClave());
                medallasPlata.agregar(paraNodo[1], nodoHashStringNodoHash.getClave());
                medallasOro.agregar(paraNodo[0], nodoHashStringNodoHash.getClave());
                medallasTotal.agregar(concatenacion,nodoHashStringNodoHash.getClave());
            }
        }


        if (tipo == 1)

        {
            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasOro.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        } else if (tipo == 2)

        {


            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasPlata.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        } else if (tipo == 3)

        {


            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasBronce.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        } else if (tipo == 4)

        {


            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasTotal.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        }
    }
}

