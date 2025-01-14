package com.alamkanak.weekview.emoji

import android.content.Context
import androidx.emoji.text.EmojiCompat
import androidx.startup.Initializer
import com.alamkanak.weekview.base.TextProcessor
import com.alamkanak.weekview.base.TextProcessors
import java.lang.IllegalStateException

@Suppress("unused")
class EmojiProcessingInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        val emojiCompat = try { EmojiCompat.get() } catch (e: IllegalStateException) { null }
        val emojiProcessor: TextProcessor = { emojiCompat?.process(it) ?: it }
        TextProcessors.register(emojiProcessor)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
