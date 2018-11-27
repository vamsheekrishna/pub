package pub.com.mypub.admin.models;

import java.util.ArrayList;

public class EventObject {
    String mTitle;
    String mAge;
    ArrayList<Language> languages = new ArrayList<>();
    int StartDate;
    int EndDate;
    int StartTime;
    int EndTime;
    int Duration;
    Category category = new Category(1,"English");
    ArrayList<Ticket> tickets = new ArrayList<>();
    ArrayList<Location> locations = new ArrayList<>();
    ArrayList<Specialist> specialists = new ArrayList<>();
   Contact contact = new Contact(1,"Hyderabad","99999932312");


    public void setLanguages(ArrayList<Language> languages) {
       // this.languages = languages;
        languages.add(new Language(1,"Arabic",false));
        languages.add(new Language(2,"English",false));
        languages.add(new Language(3,"Franch",false));
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        //this.tickets = tickets;
        tickets.add(new Ticket(2,"Ticket 3",110,"single 1","GA tickets give access to the GA zone/main dance floor at sensation Rise. Dress code:All white mandatory",false));
        tickets.add(new Ticket(3,"Ticket 3",100,"single 2","GA tickets give access to the GA zone/main dance floor at sensation Rise. Dress code:All white mandatory",false));
        tickets.add(new Ticket(4,"Ticket 3",510,"single 3","GA tickets give access to the GA zone/main dance floor at sensation Rise. Dress code:All white mandatory",false));
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setLocation(ArrayList<Location> locations) {
        //this.locations = locations;
        locations.add(new Location(1,"Banglour","India","hh","rre","eee","jjj",false));
        locations.add(new Location(2,"Chenai","India","hh","rre","eee","jjj",false));
        locations.add(new Location(3,"Delhy","India","hh","rre","eee","jjj",false));
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setSpecialists(ArrayList<Specialist> specialists) {
        //this.specialists = specialists;
       specialists.add( new Specialist(1,"Shekspeer","12/8/1770","Music","uhsfu","upload",false));
        specialists.add( new Specialist(2,"Vender","18/8/1990","Dance","uhsfu","upload",false));
        specialists.add( new Specialist(3,"Thomas","20/11/2000","Art","uhsfu","upload",false));
    }

    public ArrayList<Specialist> getSpecialists() {
        return specialists;
    }
}
