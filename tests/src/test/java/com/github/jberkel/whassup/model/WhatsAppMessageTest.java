package com.github.jberkel.whassup.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class WhatsAppMessageTest {

    @Test
    public void shouldParseTimestamp() throws Exception {
        WhatsAppMessage m = new WhatsAppMessage();
        m.timestamp = 1358086780000L;

        assertThat(m.getTimestamp().toString()).isEqualTo("Sun Jan 13 15:19:40 CET 2013");
    }

    @Test
    public void shouldParseNumber() throws Exception {
        WhatsAppMessage m = new WhatsAppMessage();
        m.key_remote_jid = "4915773981234@s.whatsapp.net";
        assertThat(m.getNumber()).isEqualTo("4915773981234");
    }

    @Test
    public void shouldParseNumberWithInvalidSpec() throws Exception {
        WhatsAppMessage m = new WhatsAppMessage();
        assertThat(m.getNumber()).isNull();
        m.key_remote_jid = "foobaz";
        assertThat(m.getNumber()).isNull();
    }
}