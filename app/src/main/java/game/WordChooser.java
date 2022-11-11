package game;
import java.util.Random;

public class WordChooser {

    // Chose a list of approximately 500 8 character words for the dictionary.
    
    public static final String[] DICTIONARY = {
        "ABSOLUTE", "ABSTRACT", "ACADEMIC", "ACCEPTED", "ACCIDENT", "ACCURACY", "ACCURATE", "ACHIEVED", "ACQUIRED", "ACTIVITY", "ACTUALLY", "ADDITION", "ADEQUATE", "ADJACENT", "ADJUSTED", "ADVANCED", "ADVISORY", "ADVOCATE", "AFFECTED", "AIRCRAFT", "ALLIANCE", "ALTHOUGH", "ALUMINUM", "ANALYSIS", "ANNOUNCE", "ANYTHING", "ANYWHERE", "APPARENT", "APPENDIX", "APPROACH", "APPROVAL", "ARGUMENT", "ARTISTIC", "ASSEMBLY", "ASSUMING", "ATHLETIC", "ATTACHED", "ATTITUDE", "ATTORNEY", "AUDIENCE", "AUTONOMY", "AVIATION", "BACHELOR", "BACTERIA", "BASEBALL", "BATHROOM", "BECOMING", "BENJAMIN", "BIRTHDAY", "BOUNDARY", "BREAKING", "BREEDING", "BUILDING", "BULLETIN", "BUSINESS", "CALENDAR", "CAMPAIGN", "CAPACITY", "CASUALTY", "CATCHING", "CATEGORY", "CATHOLIC", "CAUTIOUS", "CELLULAR", "CEREMONY", "CHAIRMAN", "CHAMPION", "CHEMICAL", "CHILDREN", "CIRCULAR", "CIVILIAN", "CLEARING", "CLINICAL", "CLOTHING", "COLLAPSE", "COLONIAL", "COLORFUL", "COMMENCE", "COMMERCE", "COMPLAIN", "COMPLETE", "COMPOSED", "COMPOUND", "COMPRISE", "COMPUTER", "CONCLUDE", "CONCRETE", "CONFLICT", "CONFUSED", "CONGRESS", "CONSIDER", "CONSTANT", "CONSUMER", "CONTINUE", "CONTRACT", "CONTRARY", "CONTRAST", "CONVINCE", "CORRIDOR", "COVERAGE", "COVERING", "CREATION", "CREATIVE", "CRIMINAL", "CRITICAL", "CROSSING", "CULTURAL", "CURRENCY", "CUSTOMER", "DATABASE", "DAUGHTER", "DAYLIGHT", "DEADLINE", "DECIDING", "DECISION", "DECREASE", "DEFERRED", "DEFINITE", "DELICATE", "DELIVERY", "DESCRIBE", "DESIGNER", "DETAILED", "DIABETES", "DIALOGUE", "DIAMETER", "DIRECTLY", "DIRECTOR", "DISABLED", "DISASTER", "DISCLOSE", "DISCOUNT", "DISCOVER", "DISORDER", "DISPOSAL", "DISTANCE", "DISTINCT", "DISTRICT", "DIVIDEND", "DIVISION", "DOCTRINE", "DOCUMENT", "DOMESTIC", "DOMINANT", "DOMINATE", "DOUBTFUL", "DRAMATIC", "DRESSING", "DROPPING", "DURATION", "DYNAMICS", "EARNINGS", "ECONOMIC", "EDUCATED", "EFFICACY", "EIGHTEEN", "ELECTION", "ELECTRIC", "ELIGIBLE", "EMERGING", "EMPHASIS", "EMPLOYEE", "ENDEAVOR", "ENGAGING", "ENGINEER", "ENORMOUS", "ENTIRELY", "ENTRANCE", "ENVELOPE", "EQUALITY", "EQUATION", "ESTIMATE", "EVALUATE", "EVENTUAL", "EVERYDAY", "EVERYONE", "EVIDENCE", "EXCHANGE", "EXCITING", "EXERCISE", "EXPLICIT", "EXPOSURE", "EXTENDED", "EXTERNAL", "FACILITY", "FAMILIAR", "FEATURED", "FEEDBACK", "FESTIVAL", "FINISHED", "FIREWALL", "FLAGSHIP", "FLEXIBLE", "FLOATING", "FOOTBALL", "FOOTHILL", "FORECAST", "FOREMOST", "FORMERLY", "FOURTEEN", "FRACTION", "FRANKLIN", "FREQUENT", "FRIENDLY", "FRONTIER", "FUNCTION", "GENERATE", "GENEROUS", "GENOMICS", "GOODWILL", "GOVERNOR", "GRADUATE", "GRAPHICS", "GRATEFUL", "GUARDIAN", "GUIDANCE", "HANDLING", "HARDWARE", "HERITAGE", "HIGHLAND", "HISTORIC", "HOMELESS", "HOMEPAGE", "HOSPITAL", "HUMANITY", "IDENTIFY", "IDENTITY", "IDEOLOGY", "IMPERIAL", "INCIDENT", "INCLUDED", "INCREASE", "INDICATE", "INDIRECT", "INDUSTRY", "INFORMAL", "INFORMED", "INHERENT", "INITIATE", "INNOCENT", "INSPIRED", "INSTANCE", "INTEGRAL", "INTENDED", "INTERACT", "INTEREST", "INTERIOR", "INTERNAL", "INTERVAL", "INTIMATE", "INTRANET", "INVASION", "INVOLVED", "ISOLATED", "JUDGMENT", "JUDICIAL", "JUNCTION", "KEYBOARD", "LANDLORD", "LANGUAGE", "LAUGHTER", "LEARNING", "LEVERAGE", "LIFETIME", "LIGHTING", "LIKEWISE", "LIMITING", "LITERARY", "LOCATION", "MAGAZINE", "MAGNETIC", "MAINTAIN", "MAJORITY", "MARGINAL", "MARRIAGE", "MATERIAL", "MATURITY", "MAXIMIZE", "MEANTIME", "MEASURED", "MEDICINE", "MEDIEVAL", "MEMORIAL", "MERCHANT", "MIDNIGHT", "MILITARY", "MINIMIZE", "MINISTER", "MINISTRY", "MINORITY", "MOBILITY", "MODELING", "MODERATE", "MOMENTUM", "MONETARY", "MOREOVER", "MORTGAGE", "MOUNTAIN", "MOUNTING", "MOVEMENT", "MULTIPLE", "NATIONAL", "NEGATIVE", "NINETEEN", "NORTHERN", "NOTEBOOK", "NUMEROUS", "OBSERVER", "OCCASION", "OFFERING", "OFFICIAL", "OFFSHORE", "OPERATOR", "OPPONENT", "OPPOSITE", "OPTIMISM", "OPTIONAL", "ORDINARY", "ORGANIZE", "ORIGINAL", "OVERCOME", "OVERHEAD", "OVERSEAS", "OVERVIEW", "PAINTING", "PARALLEL", "PARENTAL", "PATENTED", "PATIENCE", "PEACEFUL", "PERIODIC", "PERSONAL", "PERSUADE", "PETITION", "PHYSICAL", "PIPELINE", "PLATFORM", "PLEASANT", "PLEASURE", "POLITICS", "PORTABLE", "PORTRAIT", "POSITION", "POSITIVE", "POSSIBLE", "POWERFUL", "PRACTICE", "PRECIOUS", "PREGNANT", "PRESENCE", "PRESERVE", "PRESSING", "PRESSURE", "PREVIOUS", "PRINCESS", "PRINTING", "PRIORITY", "PROBABLE", "PROBABLY", "PRODUCER", "PROFOUND", "PROGRESS", "PROPERTY", "PROPOSAL", "PROSPECT", "PROTOCOL", "PROVIDED", "PROVIDER", "PROVINCE", "PUBLICLY", "PURCHASE", "PURSUANT", "QUANTITY", "QUESTION", "RATIONAL", "REACTION", "RECEIVED", "RECEIVER", "RECOVERY", "REGIONAL", "REGISTER", "RELATION", "RELATIVE", "RELEVANT", "RELIABLE", "RELIANCE", "RELIGION", "REMEMBER", "RENOWNED", "REPEATED", "REPORTER", "REPUBLIC", "REQUIRED", "RESEARCH", "RESERVED", "RESIDENT", "RESIGNED", "RESOURCE", "RESPONSE", "RESTRICT", "REVISION", "RIGOROUS", "ROMANTIC", "SAMPLING", "SCENARIO", "SCHEDULE", "SCRUTINY", "SEASONAL", "SECONDLY", "SECURITY", "SENSIBLE", "SENTENCE", "SEPARATE", "SEQUENCE", "SERGEANT", "SHIPPING", "SHORTAGE", "SHOULDER", "SIMPLIFY", "SITUATED", "SLIGHTLY", "SOFTWARE", "SOLUTION", "SOMEBODY", "SOMEWHAT", "SOUTHERN", "SPEAKING", "SPECIFIC", "SPECTRUM", "SPORTING", "STANDARD", "STANDING", "STANDOUT", "STERLING", "STRAIGHT", "STRATEGY", "STRENGTH", "STRIKING", "STRUGGLE", "STUNNING", "SUBURBAN", "SUITABLE", "SUPERIOR", "SUPPOSED", "SURGICAL", "SURPRISE", "SURVIVAL", "SWEEPING", "SWIMMING", "SYMBOLIC", "SYMPATHY", "SYNDROME", "TACTICAL", "TAILORED", "TAKEOVER", "TANGIBLE", "TAXATION", "TAXPAYER", "TEACHING", "TENDENCY", "TERMINAL", "TERRIBLE", "THINKING", "THIRTEEN", "THOROUGH", "THOUSAND", "TOGETHER", "TOMORROW", "TOUCHING", "TRACKING", "TRAINING", "TRANSFER", "TRAVELED", "TREASURY", "TRIANGLE", "TROPICAL", "TURNOVER", "ULTIMATE", "UMBRELLA", "UNIVERSE", "UNLAWFUL", "UNLIKELY", "VALUABLE", "VARIABLE", "VERTICAL", "VICTORIA", "VIOLENCE", "VOLATILE", "WARRANTY", "WEAKNESS", "WEIGHTED", "WHATEVER", "WHENEVER", "WHEREVER", "WILDLIFE", "WIRELESS", "WITHDRAW", "WOODLAND", "WORKSHOP", "YOURSELF", 
    };


    public String getRandomWord() {
        
        Random randomValue = new Random();
        return DICTIONARY[randomValue.nextInt(DICTIONARY.length)];

    }

}


