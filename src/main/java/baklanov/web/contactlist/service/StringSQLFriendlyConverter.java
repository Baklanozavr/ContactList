package baklanov.web.contactlist.service;

public class StringSQLFriendlyConverter {
    private static char[] specialSymbols = {'%', ';', '_', '\'', '\\', '\0', '\n', '\t', '\b', '\r'};

    public String modifyString(String stringForModification) {
        char[] charsForMakingSQLFriendly = stringForModification.toCharArray();

        StringBuilder resultStringFromRawChars = new StringBuilder();

        for (char symbol : charsForMakingSQLFriendly) {
            for (char specialSymbol : specialSymbols) {
                if (symbol == specialSymbol) {
                    resultStringFromRawChars.append('\\');
                    break;
                }
            }
            resultStringFromRawChars.append(symbol);
        }

        return resultStringFromRawChars.toString();
    }
}