package furhatos.app.socialClient.flow.main

import furhatos.app.socialClient.flow.Parent
import furhatos.app.socialClient.nlu.End
import furhatos.app.socialClient.setting.chatgpt.testExample
import furhatos.flow.kotlin.*



val Chatting: State = state(Parent)
{
    onEntry {
        furhat.ask("Sie können jetzt mit Piet reden")
    }

    onResponse<End> {
        furhat.say("Vielen Dank für das Gespräch, auf wiedersehen")
        goto(Idle)
    }

    onResponse()
    {
        val robotResponse = call {
            testExample.getDialogCompletion()
        } as String?
        furhat.gesture(testExample.getEmotion())
        furhat.ask(robotResponse?:"Kannst du das bitte wiederholen")
    }

    onNoResponse { // Catches silence
        furhat.ask("Ich konnte dich nicht verstehen")
    }
}