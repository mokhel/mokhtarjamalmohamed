package furhatos.app.socialClient.flow.main

import furhatos.app.socialClient.flow.Parent
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val Greeting: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.Smile(duration=1.5))
        furhat.ask("Guten Tag, möchtest du ein Gespräch mit der Persona Piet führen")
    }

    onResponse<Yes>() {
        goto(Chatting)
    }

    onResponse<No> {
        furhat.say("Dann wünsche ich noch einen schönen Tag, auf wiedersehen")
        goto(Idle)
    }

    onNoResponse { // Catches silence
        furhat.ask("Ich konnte dich nicht verstehen")
    }
}

/**
furhat.say("Oh")
furhat.gesture(Gestures.Oh)
furhat.say("Nod")
furhat.gesture(Gestures.Nod)
furhat.say("BigSmile")
furhat.gesture(Gestures.BigSmile)
furhat.say("Blink")
furhat.gesture(Gestures.Blink)
furhat.say("BrowFrown")
furhat.gesture(Gestures.BrowFrown)
furhat.say("BrowRaise")
furhat.gesture(Gestures.BrowRaise)
furhat.say("ClosedEyes")
furhat.gesture(Gestures.CloseEyes)
furhat.say("OpenEyes")
furhat.gesture(Gestures.OpenEyes)
furhat.say("ExpressAnger")
furhat.gesture(Gestures.ExpressAnger)
furhat.say("ExpressDisgust")
furhat.gesture(Gestures.ExpressDisgust)
furhat.say("ExpressFear")
furhat.gesture(Gestures.ExpressFear)
furhat.say("ExpressSad")
furhat.gesture(Gestures.ExpressSad)
furhat.say("GazeAway")
furhat.gesture(Gestures.GazeAway)
furhat.say("Roll")
furhat.gesture(Gestures.Roll)
furhat.say("Smile")
furhat.gesture(Gestures.Smile)
furhat.say("Surprise")
furhat.gesture(Gestures.Surprise)
furhat.say("Thoughtful")
furhat.gesture(Gestures.Thoughtful)
furhat.say("Wink")
furhat.gesture(Gestures.Wink)
furhat.say("Ende")
*/

