import entidades.*;
import tads.Queue.Nodo;
import tads.hash.ElementoYaExistenteException;
import tads.hash.Hash;
import tads.hash.NoExisteElemento;
import tads.hash.NodoHash;
import tads.heap.Heap;
import tads.heap.HeapImpl;
import tads.heap.NodeHeap;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Iterator;


public class Consultas {


    public static void consultaUno(int tipo) {
        NodoHash<Athlete, Integer>[] temp = Repositorio.getHashAtleta().getHash();
        if (tipo == 1) {

            HeapImpl<Integer, Athlete> medallasOro = new HeapImpl<>(150000, 1);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    medallasOro.agregar(temp[i].getValor().getMedallasOro(), temp[i].getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallasOro.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas oro: "
                        + athlete.getMedallasOro() + " - Año minimo: " + athlete.getAnioMinimoO() + " - Año maximo: " + athlete.getAnioMaximoO()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }
        } else if (tipo == 2) {
            HeapImpl<Integer, Athlete> medallasPlata = new HeapImpl<>(150000, 1);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    medallasPlata.agregar(temp[i].getValor().getMedallasPlata(), temp[i].getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallasPlata.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas plata: "
                        + athlete.getMedallasPlata() + " - Año minimo: " + athlete.getAnioMinimoP() + " - Año maximo: " + athlete.getAnioMaximoP()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }

        } else if (tipo == 3) {
            HeapImpl<Integer, Athlete> medallasBronce = new HeapImpl<>(150000, 1);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    medallasBronce.agregar(temp[i].getValor().getMedallasBronce(), temp[i].getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallasBronce.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas bronce: "
                        + athlete.getMedallasBronce() + " - Año minimo: " + athlete.getAnioMinimoB() + " - Año maximo: " + athlete.getAnioMaximoB()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }
        } else if (tipo == 4) {
            HeapImpl<Integer, Athlete> medallas = new HeapImpl<>(150000, 1);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    medallas.agregar(temp[i].getValor().getMedallas(), temp[i].getValor());
                }
            }
            for (int i = 0; i < 10; i++) {
                Athlete athlete = medallas.obtenerYEliminar().getData();
                System.out.println("Nombre: " + athlete.getName() + " - Sexo: " + athlete.getSex() + " - Medallas: "
                        + athlete.getMedallas() + " - Año minimo: " + athlete.getAnioMinimo() + " - Año maximo: " + athlete.getAnioMaximo()); //agregar vector de 2 ´para conseguir año max y minimo en la clase atleta
            }
        }


    }

    public static void consultaDos(int tipo) {

        Hash<Integer, String> hashMedOro = new Hash<>(330);
        Hash<Integer, String> hashMedPlata = new Hash<>(330);
        Hash<Integer, String> hashMedBronce = new Hash<>(330);
        Hash<Integer, String> hashMedTotal = new Hash<>(330);
        NodoHash<NationalOlympicCommittee, String>[] hashNOC = Repositorio.getHashNOC().getHash();
        NodoHash<Integer, String>[] temp1 = hashMedBronce.getHash();
        NodoHash<Integer, String>[] temp2 = hashMedPlata.getHash();
        NodoHash<Integer, String>[] temp3 = hashMedOro.getHash();
        NodoHash<Integer, String>[] temp4 = hashMedTotal.getHash();
        for (int i = 0; i < hashNOC.length; i++) {
            if (hashNOC[i] != null) {

                if (!hashMedBronce.pertenece(hashNOC[i].getValor().getRegion())) {
                    try {
                        hashMedBronce.insertar(hashNOC[i].getValor().getRegion(), hashNOC[i].getValor().getMedallasBronce());
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                } else {
                    Integer cantBronce = hashMedBronce.getValor(hashNOC[i].getValor().getRegion());
                    cantBronce = cantBronce + hashNOC[i].getValor().getMedallasBronce();
                    try {
                        hashMedBronce.borrar(hashNOC[i].getValor().getRegion());
                    } catch (NoExisteElemento noExisteElemento) {
                        System.out.println("Esto no deberia de pasar");
                    }
                    try {
                        hashMedBronce.insertar(hashNOC[i].getValor().getRegion(), cantBronce);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                }

                if (!hashMedPlata.pertenece(hashNOC[i].getValor().getRegion())) {
                    try {
                        hashMedPlata.insertar(hashNOC[i].getValor().getRegion(), hashNOC[i].getValor().getMedallasPlata());
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                } else {
                    Integer cantPlata = hashMedPlata.getValor(hashNOC[i].getValor().getRegion());
                    cantPlata = cantPlata + hashNOC[i].getValor().getMedallasPlata();
                    try {
                        hashMedPlata.borrar(hashNOC[i].getValor().getRegion());
                    } catch (NoExisteElemento noExisteElemento) {
                        System.out.println("Esto no deberia de pasar");
                    }
                    try {
                        hashMedPlata.insertar(hashNOC[i].getValor().getRegion(), cantPlata);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                }

                if (!hashMedOro.pertenece(hashNOC[i].getValor().getRegion())) {
                    try {
                        hashMedOro.insertar(hashNOC[i].getValor().getRegion(), hashNOC[i].getValor().getMedallasOro());
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                } else {
                    Integer cantOro = hashMedOro.getValor(hashNOC[i].getValor().getRegion());
                    cantOro = cantOro + hashNOC[i].getValor().getMedallasOro();
                    try {
                        hashMedOro.borrar(hashNOC[i].getValor().getRegion());
                    } catch (NoExisteElemento noExisteElemento) {
                        System.out.println("Esto no deberia de pasar");
                    }
                    try {
                        hashMedOro.insertar(hashNOC[i].getValor().getRegion(), cantOro);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                }
                if (!hashMedTotal.pertenece(hashNOC[i].getValor().getRegion())) {
                    try {
                        int medallasTotales = hashNOC[i].getValor().getMedallasBronce() + hashNOC[i].getValor().getMedallasPlata() + hashNOC[i].getValor().getMedallasOro();
                        hashMedTotal.insertar(hashNOC[i].getValor().getRegion(), medallasTotales);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                } else {
                    Integer cantMedallas = hashMedTotal.getValor(hashNOC[i].getValor().getRegion());
                    cantMedallas = cantMedallas + hashNOC[i].getValor().getMedallas();
                    try {
                        hashMedTotal.borrar(hashNOC[i].getValor().getRegion());
                    } catch (NoExisteElemento noExisteElemento) {
                        System.out.println("Esto no deberia de pasar");
                    }
                    try {
                        hashMedTotal.insertar(hashNOC[i].getValor().getRegion(), cantMedallas);
                    } catch (ElementoYaExistenteException e) {
                        System.out.println("Esto no deberia de pasar");
                    }
                }


            }
        }

        if (tipo == 1) {

            HeapImpl<Integer, String> medallasOro = new HeapImpl<>(330, 1);
            for (int i = 0; i < temp3.length; i++) {
                if (temp3[i] != null) {
                    medallasOro.agregar(temp3[i].getValor(), temp3[i].getClave());
                }
            }
            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasOro.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        } else if (tipo == 2) {

            HeapImpl<Integer, String> medallasPlata = new HeapImpl<>(330, 1);
            for (int i = 0; i < temp2.length; i++) {
                if (temp2[i] != null) {
                    medallasPlata.agregar(temp2[i].getValor(), temp2[i].getClave());
                }
            }
            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasPlata.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        } else if (tipo == 3) {

            HeapImpl<Integer, String> medallasBronce = new HeapImpl<>(330, 1);
            for (int i = 0; i < temp1.length; i++) {
                if (temp1[i] != null) {
                    medallasBronce.agregar(temp1[i].getValor(), temp1[i].getClave());
                }
            }
            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasBronce.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        } else if (tipo == 4) {

            HeapImpl<Integer, String> medallasTotal = new HeapImpl<>(330, 1);
            for (int i = 0; i < temp4.length; i++) {
                if (temp4[i] != null) {
                    medallasTotal.agregar(temp4[i].getValor(), temp4[i].getClave());
                }
            }
            for (int i = 0; i < 10; i++) {
                NodeHeap<Integer, String> regionConMedalla = medallasTotal.obtenerYEliminar();
                System.out.println("Region: " + regionConMedalla.getData() + " - Cantidad de medallas: " + regionConMedalla.getKey());
            }
        }
    }

    public static void consultaTres() {
        Hash<NodoHash<ArrayList<Athlete>, Integer>, String> organizacion = new Hash<>(1000000);
        ArrayList<AthleteOlympicParticipation> participaciones = Repositorio.getParticip();
        for (int i = 0; i < participaciones.size(); i++) {
            if (participaciones.get(i) == null) {
                i = participaciones.size();
            } else {
                AthleteOlympicParticipation temp = participaciones.get(i);
                if (organizacion.pertenece(temp.getJuegoOlimpico().getName())) {
                    if (organizacion.getValor(temp.getJuegoOlimpico().getName()).getValor().contains(temp.getAtlteta())) {

                    } else {
                        if (temp.getAtlteta().getSex() == SexType.FEMALE) {
                            Integer viejaKey = organizacion.getValor(temp.getJuegoOlimpico().getName()).getClave();
                            organizacion.getValor(temp.getJuegoOlimpico().getName()).setClave(viejaKey + 1);
                            organizacion.getValor(temp.getJuegoOlimpico().getName()).getValor().add(temp.getAtlteta());
                        }
                    }
                } else {
                    ArrayList<Athlete> inicial = new ArrayList<>(100000);
                    NodoHash<ArrayList<Athlete>, Integer> nodo = new NodoHash<>(inicial, (Integer) 0, false);
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
        for (int i = 0; i < paraHeap.length; i++) {
            if (paraHeap[i] != null) {
                mayorFemeninas.agregar(paraHeap[i].getValor().getClave(), paraHeap[i].getClave());
            }
        }

        Hash<OlympicGame, String> auxiliar = Repositorio.getHashGames();

        for (int i = 0; i < 10; i++) {

            NodeHeap<Integer, String> temp = mayorFemeninas.obtenerYEliminar();
            OlympicGame temp2 = auxiliar.getValor(temp.getData());
            System.out.println("Edicion: " + temp2.getName() + " - Año: " + temp2.getYear() + " - Cantidad de participantes femeninos:" + temp.getKey());

        }

    }

    public static void consultaCuatro(boolean tipo) {
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
                    if (organizacion.getValor(temp.getEvento().getName()).getValor().contains(temp.getAtlteta())) {

                    } else {
                        if (temp.getAtlteta().getSex() == sexoAux) {
                            Integer viejaKey = organizacion.getValor(temp.getEvento().getName()).getClave();
                            organizacion.getValor(temp.getEvento().getName()).setClave(viejaKey + 1);
                            organizacion.getValor(temp.getEvento().getName()).getValor().add(temp.getAtlteta());
                        }
                    }
                } else {
                    ArrayList<Athlete> inicial = new ArrayList<>(100000);
                    NodoHash<ArrayList<Athlete>, Integer> nodo = new NodoHash<>(inicial, (Integer) 0, false);
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

        for (int i = 0; i < paraHeap.length; i++) {
            if (paraHeap[i] != null) {
                mayor.agregar(paraHeap[i].getValor().getClave(), paraHeap[i].getClave());
            }
        }

        Hash<Event, String> auxiliar = Repositorio.getHashEventos();

        for (int i = 0; i < 5; i++) {

            NodeHeap<Integer, String> temp = mayor.obtenerYEliminar();
            Event temp3 = auxiliar.getValor(temp.getData());
            System.out.println("Competicion: " + temp3.getName() + " - Deporte: " + temp3.getDeporte().getName() + " - Sexo: " + sexoAux + " - Cantidad de participantes :" + temp.getKey());

        }
    }

    public static void consultaCinco(long min, long max) {

        Hash<NodoHash<ArrayList<Athlete>, Float>, String> organizacion = new Hash<>(1000000); // la calve va a ser cantidad de los atreltas del equipio dividio la cantidad de medakka
        ArrayList<AthleteOlympicParticipation> participaciones = Repositorio.getParticip();


        for (int i = 0; i < participaciones.size(); i++) {
            if (participaciones.get(i) == null) {
                i = participaciones.size();
            } else {
                AthleteOlympicParticipation temp = participaciones.get(i);
                if (organizacion.pertenece(temp.getAtlteta().getTeam().getName())) {
                    if (organizacion.getValor(temp.getAtlteta().getTeam().getName()).getValor().contains(temp.getAtlteta())) {

                    } else {
                        Team equipo = temp.getAtlteta().getTeam();
                        ArrayList<Athlete> listaAtleta = new ArrayList<>(1000000);
                        listaAtleta.add(temp.getAtlteta());
                        NodoHash<ArrayList<Athlete>, Float> nodo2 = new NodoHash<>(listaAtleta, (float) temp.getAtlteta().getMedallas(), false);
                        try {
                            organizacion.insertar(equipo.getName(), nodo2);
                        } catch (ElementoYaExistenteException e) {
                            System.out.println("Falla total");
                        }

                    }
                } else {
                    Team equipo=organizacion.getValor().getAtlteta().getTeam();



                }
            }
        }
    }
}

