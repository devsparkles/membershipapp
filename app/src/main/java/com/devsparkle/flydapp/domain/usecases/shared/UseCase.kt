package com.devsparkle.flydapp.domain.usecases.shared

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

open class UseCase {

    private val disposable: CompositeDisposable =
        CompositeDisposable()

    fun <T> fetch(single: Single<T>, success: (T) -> Unit, error: (Throwable) -> Unit = {}) {
        disposable.add(
            single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun <T> fetch(maybe: Maybe<T>, success: (T) -> Unit, error: (Throwable) -> Unit = {}) {
        disposable.add(
            maybe
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun <T> fetch(flowable: Flowable<T>, success: (T) -> Unit, error: (Throwable) -> Unit = {}) {
        disposable.add(
            flowable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun complete(
        completable: Completable,
        success: () -> Unit = {},
        error: (Throwable) -> Unit = {}
    ) {
        disposable.add(
            completable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun clear() {
        disposable.clear()
    }
}