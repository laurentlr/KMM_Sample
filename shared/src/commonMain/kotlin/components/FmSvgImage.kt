package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.AsyncImagePainter
import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.component.setupKtorComponents
import com.seiko.imageloader.rememberAsyncImagePainter
import io.ktor.client.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

/*
val customKamelConfig = KamelConfig {
    // Copies the default implementation if needed
    takeFrom(KamelConfig.Default)

    // Sets the number of images to cache
    imageBitmapCacheSize = DefaultCacheSize

    // adds an ImageBitmapDecoder
    //imageBitmapDecoder()

    // adds an ImageVectorDecoder (XML)
    //imageVectorDecoder()

    // adds an SvgDecoder (SVG)
    svgDecoder()

    // adds a FileFetcher
    //fileFetcher()

    // Configures Ktor HttpClient
    httpFetcher {
        install(HttpRequestRetry) {
            maxRetries = 3
            retryIf { httpRequest, httpResponse ->
                !httpResponse.status.isSuccess()
            }
        }

        // Requires adding "io.ktor:ktor-client-logging:$ktor_version"
        *//*Logging {
            level = LogLevel.INFO
            logger = Logger.SIMPLE
        }*//*
    }

    // more functionality available.
}*/

@Composable
fun FmSvgImage(
    url: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
) {
    /* CompositionLocalProvider(LocalKamelConfig provides customKamelConfig) {
         val painterResource: Resource<Painter> = asyncPainterResource(url) {

             // CoroutineContext to be used while loading the image.
             coroutineContext = Dispatchers.IO

             // Customizes HTTP request
             requestBuilder { // this: HttpRequestBuilder
                 //cacheControl(CacheControl.MAX_AGE)
             }
         }
         KamelImage(painterResource, null)
     }*/

    CompositionLocalProvider(
        LocalImageLoader provides generateImageLoader(),
    ) {
        val painter: AsyncImagePainter = rememberAsyncImagePainter("https://rdironworks.com/wp-content/uploads/2017/12/dummy-200x200.png")
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.width(200.dp).height(200.dp)
        )
    }
}

// in android
fun generateImageLoader(): ImageLoader {
    return ImageLoader( requestCoroutineContext = Dispatchers.IO ) {
        components {
            setupKtorComponents { HttpClient() }
            // or
            //
            // setupBase64Components()
            // setupCommonComponents()
            // setupJvmComponents()
            // setupAndroidComponents(context, maxImageSize)
            // or
            // add(KtorUrlMapper())
            // add(KtorUrlKeyer())
            // add(KtorUrlFetcher.Factory(httpClient))
            // ....
        }
        interceptor {
            useDefaultInterceptors = true
            //addInterceptor(
        }
    }
}
