
(ns email-agent.api
    (:require [email-agent.side-effects :as side-effects]
              [email-agent.utils        :as utils]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @tutorial Demo
;
; @usage
; (send-message! {:host     "smtp.my-host.com"
;                 :password "..."
;                 :username "my-user@my-host.com"
;                 :port     465}
;                {:body     "Hello World!"
;                 :from     "sender@provider.com"
;                 :subject  "Greatings"
;                 :to       "receiver@provider.com"})
;
; @usage
; (send-message! {...}
;                {:body "Hello World!" ...})
;
; @usage
; (send-message! {...}
;                {:body [:html [:body [:div "Hello World!"]]] ...})
;
; @usage
; (send-message! {...}
;                {:body (text-body "Hello World!") ...})
;
; @usage
; (send-message! {...}
;                {:body ["Hello World!"
;                        [:html [:body [:div "Hello World!"]]]
;                        {:type "text/plain" :content "Hello World!"}
;                        (text-body            "Hello World!")
;                        (html-body            "<html><body>Hello World!</body></html>")
;                        (hiccup-body          [:html [:body "Hello World!"]])
;                        (attachment-file-body "my-file.pdf")
;                        (attachment-file-body (java.io.File. "my-file.pdf"))
;                        (inline-file-body     "my-file.pdf")
;                        (inline-file-body     "my-file.pdf" "application/pdf")
;                        (inline-file-body     (java.io.File. "my-file.pdf") "application/pdf")] ...})
;
; @usage
; (send-message! {...}
;                {:body [:alternative
;                        (text-body "Hello World!")
;                        (html-body "<html><body>Hello World!</body></html>")] ...})

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @tutorial How to acknowledge an email sending?
;
; The [acknowledged?](#acknowledge_) function returns TRUE if the message has been sent without errors.
;
; @usage
; (acknowledged? (send-message! {...} {...}))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (email-agent.side-effects/*)
(def send-message! side-effects/send-message!)

; @redirect (email-agent.utils/*)
(def acknowledged?        utils/acknowledged?)
(def sender-label         utils/sender-label)
(def inline-file-body     utils/inline-file-body)
(def attachment-file-body utils/attachment-file-body)
(def text-body            utils/text-body)
(def hiccup-body          utils/hiccup-body)
(def html-body            utils/html-body)
