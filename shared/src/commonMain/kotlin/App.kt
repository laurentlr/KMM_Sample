import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import components.ListView
import dataDomain.*
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        ListView(
            SdList(
                SdOrientation.Vertical,
                listOf(
                    getTopCard(),
                    getBanner(),
                    getBanner2(),
                    SdList(
                        SdOrientation.Horizontal,
                        listOf(getSellCard(), getSellCard(), getSellCard()),
                        scrollable = SdScrollable.Scroll,
                    )

                ),
                scrollable = SdScrollable.Scroll
            )
        )
    }
}

private fun getBanner() = SdBanner(
    SdText("Upcoming repayment"),
    SdText("₦27,500 due by 7 Sep"),
    listOf(SdMainButton("Repay", SdDeeplink("https://fairmoney/faq"))),
    SdIcon(("https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.3.0/flags/1x1/ad.svg")),
    SdStyle(
        backgroundColor = SdColor(0xFFFFF5F5),
        borderColor = SdColor(0xFFFF6767),
    )
)

private fun getBanner2() = SdBanner(
    title = SdText("Upcoming repayment"),
    body = SdText("Friendly reminder that your loan repayment of ₦27,500 was due on 7 Sep."),
    buttons = listOf(
        SdMainButton(
            "Chat",
            SdDeeplink("https://fairmoney/faq"),
            SdStyle(
                backgroundColor = SdColor(0XFFFFFFFF),
                textColor = SdColor(0xFF000000),
                borderColor = SdColor(0xFFFF0000),
            )
        ),
        SdMainButton("Repay", SdDeeplink("https://fairmoney/pay")),
    ),
    icon = SdIcon(("https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.3.0/flags/1x1/ad.svg")),
    style = SdStyle(
        backgroundColor = SdColor(0xFFFFF5F5),
        borderColor = SdColor(0xFFFF6767),
    )
)

private fun getSellCard() = SdSellCard(
    title = SdText(
        "Get a loan in 5 minutes!",
    ),
    body = SdText(
        "Up to ₦300,000 available for all your needs",
    ),
    icon = null,
    button = SdLinkButton(
        text = "Learn more",
        style = SdStyle(textColor = SdColor(0xffffffff)),
        deeplink = SdDeeplink("https://fairmoney.io/faq"),
    ),
    style = SdStyle(
        backgroundColor = SdColor(0xFF37A477),
        backgroundImage = SdIcon(
            "https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.3.0/flags/1x1/ad.svg"
        )
    )
)

private fun getTopCard() = SdCarousel(
    listOf(
        sdTopCardWithActions(),
        sdTopCardWithActions(),
        sdTopCardWithActions()
    )
)

private fun sdTopCardWithActions() = SdTopCardWithActions(
    SdTopCard(
        title = SdText("Transfer", SdStyle(textColor = SdColor(0xFF1E1F26))),
        subtitle = SdText("Account balance", SdStyle(textColor = SdColor(0xFF6F7280))),
        style = SdStyle(
            backgroundColor = SdColor(0xFFF0FBF6),
            borderColor = SdColor(0xFF37A477),
        ),
    ), null
)

