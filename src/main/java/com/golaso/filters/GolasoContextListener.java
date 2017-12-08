package com.golaso.filters;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by dheinisch on 12/8/17.
 */
public class GolasoContextListener implements ServletContextListener {
    private FirebaseApp app;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            app = FirebaseApp.getInstance();
        } catch (IllegalStateException e) {
            ByteArrayInputStream serviceAccount = new ByteArrayInputStream(getKey().getBytes());

            FirebaseOptions options = null;
            try {
                options = new FirebaseOptions.Builder()
                        .setProjectId("golaso-188317")
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl("https://goalso-188317.firebaseio.com/")
                        .build();
                app = FirebaseApp.initializeApp(options);
            } catch (IOException ex) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public String getKey() {
        return "{\n" +
                "  \"type\": \"service_account\",\n" +
                "  \"project_id\": \"goalso-188317\",\n" +
                "  \"private_key_id\": \"9043aa7b9219287b3b37844edfc133e7ca6c56cb\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCbPvQWQWT6OFH5\\nZYTSkJx7/6tMbcapFZCS0BkaSW84rfvLVGjxuNbhxwcAtJng8Fp3tEOgK8OijC7d\\nb/zMd8Os8M5f8XYiBLxYFD3e38JppFovhAJQlGHrMhWDaB5y1v4CJSJ/8/V0fxKo\\n6DyKWYMNehL2uxZOt+7ALuaRdf3z15UFCBFtEoDMzx3nFKjmSNrrW6Ri2AqTBkcB\\nsb7hsMd+cjJ/JWkBfmgpYt7N14He7ZxpTPgG2DWGQ2pEeVZ3NOHdVaVdBUgKe6jV\\npHXrYelZW2LIXZ26VwdUhxsTlzX7PWwRY7fZ6mLbvFZeB5wGdsMfxXfoF/DgqdyJ\\nUw+ttrnpAgMBAAECggEALvIIibpYuLnTQCGM2sfUKkMUH9aKXpMg1uSK0sImGfOy\\n0rfBzGbiw/+VhIcYiUbldJFUadkSHdNaUKgOwB3vVBq1rZms6XiZI+FrHDx548xJ\\nYVkAAjH8skzA6K3Rl1SgFzH3js3NCd9rWxxvQj7zPF4P4gCNLFy+m+sS2iXeF6A+\\n1cBJKPBgG5ygclWdHEYVbpk755E+nq6Sc5jFFpXedi4BZRZk/OBbIMEGUrmM88K8\\n45LQ7vnvL1vq9sKNDwAtnxCGbUGZaxbjrPa0QcrahPoHMm14+e7Px87eJGIEkAGC\\nr+02I26zKTKKCRjS0b4/0Ejd/QMhm2iPXNAdJFFTyQKBgQDNgcs6eu8ASa51npGL\\nd3TF6SiatbxkEjNTG1gYHGGrsH7OLd8Sr83XlvXRyMO1LVuCpftTJXARLWv8W/G9\\nC7csMTJnEfjKf2o+rxGRR57p9GGL9Kg+xs8XFoD9q8fuvtJHCYMs6MAIt1J4+/MU\\nL54oirXU+SNdxczfM78QO9c99wKBgQDBY8goE/0Y9x4f8GNLFcJqJvrdpJFNECRK\\n9j+0Q9ZDqtxTnSe4vAJ2Qev9mXnM/JmO/6XO6rjZR4SL0Q1FvuwljFUwbCtG8dym\\nRVan3n8SuKYUXD0DS8lUrl9S+Ko+jhuxWTUTCHU27inoL9h9rcEmuxTgoRLsQUCF\\nszYWe/FPHwKBgQCSqwCVQymSBgQZ88qiQ+Y2XXpaODw1G3w/4vMTeiYG99b4ZWqg\\nlpINPLNCPsvWYYG/E6D0LXL2/3jjSeeUaWkYhCAZyYzLUPZNuHqMOhZjmMOJtFnj\\nO9aO/sOex9vQO6Yths903MQ5NEULDZ3lmTqCasTtM8YW5dWasv64okyy7wKBgBrn\\nI6gXp8T6U7GDwnxmiYY05/8/bos27KWU/iW4riz5ru7e1PDJDtqerxK3cA9JMJ+J\\nBurzEkX/wfulWGBUgAt1K0CyO48CBH0I9lYiCLF1CH2am05DE735B//F4gETydxx\\nGYYNTikXFrNbPJW3P0CBFBVvsu804KH43VRhZ59nAoGAAdF1XMNjWv+xCz+cFPd9\\nl8JX1N8fc+frS+lcRV7zYV/XkHjq8Aq0y36rdYT0jhRyR5HCD4825f6LCbGK+fkf\\nEhHLEjSEiNp8sVQNtOgvNscacPY0rpTbqXMxEDMRSp8Kl1meb5vHl+iyvgsC4+QF\\nEtg2OFGOakspw6wgF6bm8YA=\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-ou4xe@goalso-188317.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"112651284212570667966\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://accounts.google.com/o/oauth2/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-ou4xe%40goalso-188317.iam.gserviceaccount.com\"\n" +
                "}\n";
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        FirebaseApp.getInstance().delete();
    }
}
