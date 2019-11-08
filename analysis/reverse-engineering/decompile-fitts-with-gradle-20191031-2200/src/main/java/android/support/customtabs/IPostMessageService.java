package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPostMessageService extends IInterface {

    public static abstract class Stub extends Binder implements IPostMessageService {
        private static final String DESCRIPTOR = "android.support.customtabs.IPostMessageService";
        static final int TRANSACTION_onMessageChannelReady = 2;
        static final int TRANSACTION_onPostMessage = 3;

        private static class Proxy implements IPostMessageService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCustomTabsCallback != null ? iCustomTabsCallback.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPostMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCustomTabsCallback != null ? iCustomTabsCallback.asBinder() : null);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPostMessageService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPostMessageService)) {
                return new Proxy(iBinder);
            }
            return (IPostMessageService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle = null;
            String str = DESCRIPTOR;
            if (i == 2) {
                parcel.enforceInterface(str);
                ICustomTabsCallback asInterface = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                onMessageChannelReady(asInterface, bundle);
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(str);
                ICustomTabsCallback asInterface2 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(parcel.readStrongBinder());
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                onPostMessage(asInterface2, readString, bundle);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(str);
                return true;
            }
        }
    }

    void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException;

    void onPostMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) throws RemoteException;
}
